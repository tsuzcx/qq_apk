package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.protocal.protobuf.eie;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ad;
import java.util.LinkedList;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private RecyclerView jLl;
  private ImageView jmf;
  private LinearLayout jmn;
  private TextView kEs;
  private com.tencent.mm.ui.b mActionBarHelper;
  AppBrandIDCardUI.a raQ;
  private View raR;
  private TextView raS;
  private Button raT;
  private CheckBox raU;
  private TextView raV;
  private LinearLayout raW;
  private View raX;
  private TextView raY;
  private TextView raZ;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.raQ == null) || (this.raQ.ckF() == null))
    {
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.jmn = ((LinearLayout)paramView.findViewById(au.f.app_brand_idcard_show_layout));
    this.jmf = ((ImageView)paramView.findViewById(au.f.app_brand_idcard_show_icon));
    this.kEs = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_desc));
    this.jLl = ((RecyclerView)paramView.findViewById(au.f.app_brand_idcard_show_list));
    this.raS = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_busi_desc));
    this.raT = ((Button)paramView.findViewById(au.f.app_brand_idcard_show_confirm));
    this.raU = ((CheckBox)paramView.findViewById(au.f.app_brand_idcard_show_checkbox));
    this.raV = ((TextView)paramView.findViewById(au.f.app_brand_show_protocal));
    this.raW = ((LinearLayout)paramView.findViewById(au.f.app_brand_idcard_show_bottom_layout));
    this.raX = paramView.findViewById(au.f.app_brand_idcard_show_url_line);
    this.raY = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_url_1));
    this.raZ = ((TextView)paramView.findViewById(au.f.app_brand_idcard_show_url_2));
    this.raR = ad.kS(getContext()).inflate(au.g.actionbar_custom_area, null);
    this.raR.setBackgroundColor(getResources().getColor(au.c.normal_actionbar_color));
    this.mActionBarHelper = new com.tencent.mm.ui.b(this.raR);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.ew(getActivity()));
    this.jmn.addView(this.raR, 0, paramView);
    paramView = this.raQ.ckF();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).ckA();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.jmf, paramView.TKZ, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
    this.kEs.setText(paramView.lnp + " " + paramView.UfT);
    if (paramView.Ukd != null)
    {
      this.jLl.setVisibility(0);
      RecyclerView localRecyclerView = this.jLl;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.jLl.setAdapter(new AppBrandIDCardShowFrag.a(paramView.Ukd));
      this.raS.setText(paramView.Uke);
      if (Util.isNullOrNil(paramView.Ukf)) {
        break label670;
      }
      this.raT.setText(paramView.Ukf);
      label461:
      Log.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.Ukj) });
      this.raU.setChecked(paramView.Ukj);
      this.raT.setEnabled(paramView.Ukj);
      if (Util.isNullOrNil(paramView.Ukk)) {
        break label687;
      }
      this.raU.setText(paramView.Ukk);
    }
    for (;;)
    {
      this.raU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(48910);
          if (AppBrandIDCardShowFrag.b(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.b(AppBrandIDCardShowFrag.this).setEnabled(paramAnonymousBoolean);
          }
          AppMethodBeat.o(48910);
        }
      });
      this.raT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).ckD();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.Ukg != null)
      {
        this.raV.setText(paramView.Ukg.name);
        this.raV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).amV(paramView.Ukg.url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.Ukh == null) {
        break label915;
      }
      Log.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.Ukh.size()) });
      if (paramView.Ukh.size() != 0) {
        break label704;
      }
      this.raW.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.jLl.setVisibility(8);
      break;
      label670:
      this.raT.setText(getString(au.i.app_brand_idcard_show_default_confirm_text));
      break label461;
      label687:
      this.raU.setText(getString(au.i.app_brand_idcard_show_legal_agreement_prefix));
    }
    label704:
    if (paramView.Ukh.size() == 1)
    {
      this.raW.setVisibility(0);
      this.raX.setVisibility(8);
      this.raZ.setVisibility(8);
      if (paramView.Ukh.get(0) != null)
      {
        this.raY.setText(((hj)paramView.Ukh.get(0)).name);
        this.raY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).amW(((hj)paramView.Ukh.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48913);
          }
        });
        AppMethodBeat.o(48920);
      }
    }
    else
    {
      this.raW.setVisibility(0);
      this.raX.setVisibility(0);
      this.raZ.setVisibility(0);
      if (paramView.Ukh.get(0) != null)
      {
        this.raY.setText(((hj)paramView.Ukh.get(0)).name);
        this.raY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).amW(((hj)paramView.Ukh.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.Ukh.get(1) != null)
      {
        this.raZ.setText(((hj)paramView.Ukh.get(1)).name);
        this.raZ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).amX(((hj)paramView.Ukh.get(1)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48915);
          }
        });
      }
    }
    label915:
    AppMethodBeat.o(48920);
  }
  
  public int getLayoutId()
  {
    return au.g.app_brand_idcard_show_ui;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48921);
    if (this.raQ != null) {
      this.raQ.onSwipeBack();
    }
    AppMethodBeat.o(48921);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */