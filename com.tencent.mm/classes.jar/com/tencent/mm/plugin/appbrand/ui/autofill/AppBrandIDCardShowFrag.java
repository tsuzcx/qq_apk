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
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.protocal.protobuf.fcg;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.af;
import java.util.LinkedList;
import java.util.List;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private TextView descTv;
  private ImageView lPb;
  private LinearLayout lPl;
  private com.tencent.mm.ui.b mActionBarHelper;
  private RecyclerView mkw;
  AppBrandIDCardUI.a ugH;
  private View ugI;
  private TextView ugJ;
  private Button ugK;
  private CheckBox ugL;
  private TextView ugM;
  private LinearLayout ugN;
  private View ugO;
  private TextView ugP;
  private TextView ugQ;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.ugH == null) || (this.ugH.cLT() == null))
    {
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.lPl = ((LinearLayout)paramView.findViewById(ba.f.app_brand_idcard_show_layout));
    this.lPb = ((ImageView)paramView.findViewById(ba.f.app_brand_idcard_show_icon));
    this.descTv = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_desc));
    this.mkw = ((RecyclerView)paramView.findViewById(ba.f.app_brand_idcard_show_list));
    this.ugJ = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_busi_desc));
    this.ugK = ((Button)paramView.findViewById(ba.f.app_brand_idcard_show_confirm));
    this.ugL = ((CheckBox)paramView.findViewById(ba.f.app_brand_idcard_show_checkbox));
    this.ugM = ((TextView)paramView.findViewById(ba.f.app_brand_show_protocal));
    this.ugN = ((LinearLayout)paramView.findViewById(ba.f.app_brand_idcard_show_bottom_layout));
    this.ugO = paramView.findViewById(ba.f.app_brand_idcard_show_url_line);
    this.ugP = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_url_1));
    this.ugQ = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_url_2));
    this.ugI = af.mU(getContext()).inflate(ba.g.actionbar_custom_area, null);
    this.ugI.setBackgroundColor(getResources().getColor(ba.c.normal_actionbar_color));
    this.mActionBarHelper = new com.tencent.mm.ui.b(this.ugI);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.fs(getActivity()));
    this.lPl.addView(this.ugI, 0, paramView);
    paramView = this.ugH.cLT();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).cLO();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.lPb, paramView.abaT, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
    this.descTv.setText(paramView.nSt + " " + paramView.YJg);
    if (paramView.abBM != null)
    {
      this.mkw.setVisibility(0);
      RecyclerView localRecyclerView = this.mkw;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.mkw.setAdapter(new a(paramView.abBM));
      this.ugJ.setText(paramView.abBN);
      if (Util.isNullOrNil(paramView.abBO)) {
        break label670;
      }
      this.ugK.setText(paramView.abBO);
      label461:
      Log.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.abBS) });
      this.ugL.setChecked(paramView.abBS);
      this.ugK.setEnabled(paramView.abBS);
      if (Util.isNullOrNil(paramView.abBT)) {
        break label687;
      }
      this.ugL.setText(paramView.abBT);
    }
    for (;;)
    {
      this.ugL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.ugK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).cLR();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.abBP != null)
      {
        this.ugM.setText(paramView.abBP.name);
        this.ugM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).agj(paramView.abBP.url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.abBQ == null) {
        break label915;
      }
      Log.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.abBQ.size()) });
      if (paramView.abBQ.size() != 0) {
        break label704;
      }
      this.ugN.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.mkw.setVisibility(8);
      break;
      label670:
      this.ugK.setText(getString(ba.i.app_brand_idcard_show_default_confirm_text));
      break label461;
      label687:
      this.ugL.setText(getString(ba.i.app_brand_idcard_show_legal_agreement_prefix));
    }
    label704:
    if (paramView.abBQ.size() == 1)
    {
      this.ugN.setVisibility(0);
      this.ugO.setVisibility(8);
      this.ugQ.setVisibility(8);
      if (paramView.abBQ.get(0) != null)
      {
        this.ugP.setText(((if)paramView.abBQ.get(0)).name);
        this.ugP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).agk(((if)paramView.abBQ.get(0)).url);
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
      this.ugN.setVisibility(0);
      this.ugO.setVisibility(0);
      this.ugQ.setVisibility(0);
      if (paramView.abBQ.get(0) != null)
      {
        this.ugP.setText(((if)paramView.abBQ.get(0)).name);
        this.ugP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).agk(((if)paramView.abBQ.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.abBQ.get(1) != null)
      {
        this.ugQ.setText(((if)paramView.abBQ.get(1)).name);
        this.ugQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).agl(((if)paramView.abBQ.get(1)).url);
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
    return ba.g.app_brand_idcard_show_ui;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48921);
    if (this.ugH != null) {
      this.ugH.onSwipeBack();
    }
    AppMethodBeat.o(48921);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  public static final class a
    extends RecyclerView.a<a>
  {
    private List<ie> eXW;
    
    public a(List<ie> paramList)
    {
      this.eXW = paramList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(48917);
      if (this.eXW == null)
      {
        AppMethodBeat.o(48917);
        return 0;
      }
      int i = this.eXW.size();
      AppMethodBeat.o(48917);
      return i;
    }
    
    public static final class a
      extends RecyclerView.v
    {
      public TextView lDF;
      public TextView tug;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(48916);
        this.lDF = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_item_name));
        this.tug = ((TextView)paramView.findViewById(ba.f.app_brand_idcard_show_item_value));
        AppMethodBeat.o(48916);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */