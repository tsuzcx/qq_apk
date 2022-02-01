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
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private ImageView fUN;
  private LinearLayout fUV;
  private TextView gUs;
  private RecyclerView gmV;
  private com.tencent.mm.ui.a mActionBarHelper;
  AppBrandIDCardUI.a mGT;
  private View mGU;
  private TextView mGV;
  private Button mGW;
  private CheckBox mGX;
  private TextView mGY;
  private LinearLayout mGZ;
  private View mHa;
  private TextView mHb;
  private TextView mHc;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.mGT == null) || (this.mGT.bzU() == null))
    {
      ad.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.fUV = ((LinearLayout)paramView.findViewById(2131296747));
    this.fUN = ((ImageView)paramView.findViewById(2131296744));
    this.gUs = ((TextView)paramView.findViewById(2131296743));
    this.gmV = ((RecyclerView)paramView.findViewById(2131296749));
    this.mGV = ((TextView)paramView.findViewById(2131296740));
    this.mGW = ((Button)paramView.findViewById(2131296742));
    this.mGX = ((CheckBox)paramView.findViewById(2131296741));
    this.mGY = ((TextView)paramView.findViewById(2131296833));
    this.mGZ = ((LinearLayout)paramView.findViewById(2131296739));
    this.mHa = paramView.findViewById(2131296752);
    this.mHb = ((TextView)paramView.findViewById(2131296750));
    this.mHc = ((TextView)paramView.findViewById(2131296751));
    this.mGU = z.jO(getContext()).inflate(2131492921, null);
    this.mGU.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.mGU);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dT(getActivity()));
    this.fUV.addView(this.mGU, 0, paramView);
    paramView = this.mGT.bzU();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.fUN, paramView.GXm, com.tencent.mm.modelappbrand.a.a.aDU(), g.hLC);
    this.gUs.setText(paramView.hBg + " " + paramView.Hsx);
    if (paramView.Hsy != null)
    {
      this.gmV.setVisibility(0);
      RecyclerView localRecyclerView = this.gmV;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.gmV.setAdapter(new AppBrandIDCardShowFrag.a(paramView.Hsy));
      this.mGV.setText(paramView.Hsz);
      if (bt.isNullOrNil(paramView.HsA)) {
        break label655;
      }
      this.mGW.setText(paramView.HsA);
      label446:
      ad.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.HsE) });
      this.mGX.setChecked(paramView.HsE);
      this.mGW.setEnabled(paramView.HsE);
      if (bt.isNullOrNil(paramView.HsF)) {
        break label672;
      }
      this.mGX.setText(paramView.HsF);
    }
    for (;;)
    {
      this.mGX.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.mGW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).bzS();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.HsB != null)
      {
        this.mGY.setText(paramView.HsB.name);
        this.mGY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).UM(paramView.HsB.url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.HsC == null) {
        break label900;
      }
      ad.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.HsC.size()) });
      if (paramView.HsC.size() != 0) {
        break label689;
      }
      this.mGZ.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      ad.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.gmV.setVisibility(8);
      break;
      label655:
      this.mGW.setText(getString(2131755460));
      break label446;
      label672:
      this.mGX.setText(getString(2131755461));
    }
    label689:
    if (paramView.HsC.size() == 1)
    {
      this.mGZ.setVisibility(0);
      this.mHa.setVisibility(8);
      this.mHc.setVisibility(8);
      if (paramView.HsC.get(0) != null)
      {
        this.mHb.setText(((hg)paramView.HsC.get(0)).name);
        this.mHb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).UN(((hg)paramView.HsC.get(0)).url);
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
      this.mGZ.setVisibility(0);
      this.mHa.setVisibility(0);
      this.mHc.setVisibility(0);
      if (paramView.HsC.get(0) != null)
      {
        this.mHb.setText(((hg)paramView.HsC.get(0)).name);
        this.mHb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).UN(((hg)paramView.HsC.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.HsC.get(1) != null)
      {
        this.mHc.setText(((hg)paramView.HsC.get(1)).name);
        this.mHc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).UO(((hg)paramView.HsC.get(1)).url);
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
    return 2131493003;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(48921);
    if (this.mGT != null) {
      this.mGT.onSwipeBack();
    }
    AppMethodBeat.o(48921);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */