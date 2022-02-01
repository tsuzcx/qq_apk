package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.protocal.protobuf.dyd;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import java.util.LinkedList;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private ImageView gBZ;
  private LinearLayout gCh;
  private TextView hPW;
  private RecyclerView hak;
  private com.tencent.mm.ui.a mActionBarHelper;
  AppBrandIDCardUI.a nZf;
  private View nZg;
  private TextView nZh;
  private Button nZi;
  private CheckBox nZj;
  private TextView nZk;
  private LinearLayout nZl;
  private View nZm;
  private TextView nZn;
  private TextView nZo;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.nZf == null) || (this.nZf.bXU() == null))
    {
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.gCh = ((LinearLayout)paramView.findViewById(2131296828));
    this.gBZ = ((ImageView)paramView.findViewById(2131296825));
    this.hPW = ((TextView)paramView.findViewById(2131296824));
    this.hak = ((RecyclerView)paramView.findViewById(2131296830));
    this.nZh = ((TextView)paramView.findViewById(2131296821));
    this.nZi = ((Button)paramView.findViewById(2131296823));
    this.nZj = ((CheckBox)paramView.findViewById(2131296822));
    this.nZk = ((TextView)paramView.findViewById(2131296918));
    this.nZl = ((LinearLayout)paramView.findViewById(2131296820));
    this.nZm = paramView.findViewById(2131296833);
    this.nZn = ((TextView)paramView.findViewById(2131296831));
    this.nZo = ((TextView)paramView.findViewById(2131296832));
    this.nZg = aa.jQ(getContext()).inflate(2131492939, null);
    this.nZg.setBackgroundColor(getResources().getColor(2131100898));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.nZg);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.eu(getActivity()));
    this.gCh.addView(this.nZg, 0, paramView);
    paramView = this.nZf.bXU();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.gBZ, paramView.Mzt, com.tencent.mm.modelappbrand.a.a.aXX(), g.iJB);
    this.hPW.setText(paramView.ixZ + " " + paramView.MTK);
    if (paramView.MXI != null)
    {
      this.hak.setVisibility(0);
      RecyclerView localRecyclerView = this.hak;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.hak.setAdapter(new AppBrandIDCardShowFrag.a(paramView.MXI));
      this.nZh.setText(paramView.MXJ);
      if (Util.isNullOrNil(paramView.MXK)) {
        break label655;
      }
      this.nZi.setText(paramView.MXK);
      label446:
      Log.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.MXO) });
      this.nZj.setChecked(paramView.MXO);
      this.nZi.setEnabled(paramView.MXO);
      if (Util.isNullOrNil(paramView.MXP)) {
        break label672;
      }
      this.nZj.setText(paramView.MXP);
    }
    for (;;)
    {
      this.nZj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.nZi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).bXS();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.MXL != null)
      {
        this.nZk.setText(paramView.MXL.name);
        this.nZk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).aft(paramView.MXL.url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.MXM == null) {
        break label900;
      }
      Log.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.MXM.size()) });
      if (paramView.MXM.size() != 0) {
        break label689;
      }
      this.nZl.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      Log.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.hak.setVisibility(8);
      break;
      label655:
      this.nZi.setText(getString(2131755498));
      break label446;
      label672:
      this.nZj.setText(getString(2131755499));
    }
    label689:
    if (paramView.MXM.size() == 1)
    {
      this.nZl.setVisibility(0);
      this.nZm.setVisibility(8);
      this.nZo.setVisibility(8);
      if (paramView.MXM.get(0) != null)
      {
        this.nZn.setText(((ht)paramView.MXM.get(0)).name);
        this.nZn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).afu(((ht)paramView.MXM.get(0)).url);
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
      this.nZl.setVisibility(0);
      this.nZm.setVisibility(0);
      this.nZo.setVisibility(0);
      if (paramView.MXM.get(0) != null)
      {
        this.nZn.setText(((ht)paramView.MXM.get(0)).name);
        this.nZn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).afu(((ht)paramView.MXM.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.MXM.get(1) != null)
      {
        this.nZo.setText(((ht)paramView.MXM.get(1)).name);
        this.nZo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).afv(((ht)paramView.MXM.get(1)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48915);
          }
        });
      }
    }
    label900:
    AppMethodBeat.o(48920);
  }
  
  public int getLayoutId()
  {
    return 2131493041;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48921);
    if (this.nZf != null) {
      this.nZf.onSwipeBack();
    }
    AppMethodBeat.o(48921);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */