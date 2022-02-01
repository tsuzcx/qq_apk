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
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private ImageView fWT;
  private LinearLayout fXb;
  private TextView gXb;
  private RecyclerView gpr;
  private com.tencent.mm.ui.a mActionBarHelper;
  AppBrandIDCardUI.a mLX;
  private View mLY;
  private TextView mLZ;
  private Button mMa;
  private CheckBox mMb;
  private TextView mMc;
  private LinearLayout mMd;
  private View mMe;
  private TextView mMf;
  private TextView mMg;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.mLX == null) || (this.mLX.bAP() == null))
    {
      ae.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.fXb = ((LinearLayout)paramView.findViewById(2131296747));
    this.fWT = ((ImageView)paramView.findViewById(2131296744));
    this.gXb = ((TextView)paramView.findViewById(2131296743));
    this.gpr = ((RecyclerView)paramView.findViewById(2131296749));
    this.mLZ = ((TextView)paramView.findViewById(2131296740));
    this.mMa = ((Button)paramView.findViewById(2131296742));
    this.mMb = ((CheckBox)paramView.findViewById(2131296741));
    this.mMc = ((TextView)paramView.findViewById(2131296833));
    this.mMd = ((LinearLayout)paramView.findViewById(2131296739));
    this.mMe = paramView.findViewById(2131296752);
    this.mMf = ((TextView)paramView.findViewById(2131296750));
    this.mMg = ((TextView)paramView.findViewById(2131296751));
    this.mLY = z.jV(getContext()).inflate(2131492921, null);
    this.mLY.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.mLY);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dX(getActivity()));
    this.fXb.addView(this.mLY, 0, paramView);
    paramView = this.mLX.bAP();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).back();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.fWT, paramView.HqM, com.tencent.mm.modelappbrand.a.a.aEk(), g.hOv);
    this.gXb.setText(paramView.hDU + " " + paramView.HMa);
    if (paramView.HMb != null)
    {
      this.gpr.setVisibility(0);
      RecyclerView localRecyclerView = this.gpr;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.gpr.setAdapter(new AppBrandIDCardShowFrag.a(paramView.HMb));
      this.mLZ.setText(paramView.HMc);
      if (bu.isNullOrNil(paramView.HMd)) {
        break label655;
      }
      this.mMa.setText(paramView.HMd);
      label446:
      ae.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.HMh) });
      this.mMb.setChecked(paramView.HMh);
      this.mMa.setEnabled(paramView.HMh);
      if (bu.isNullOrNil(paramView.HMi)) {
        break label672;
      }
      this.mMb.setText(paramView.HMi);
    }
    for (;;)
    {
      this.mMb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.mMa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).bAN();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.HMe != null)
      {
        this.mMc.setText(paramView.HMe.name);
        this.mMc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Vx(paramView.HMe.url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.HMf == null) {
        break label900;
      }
      ae.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.HMf.size()) });
      if (paramView.HMf.size() != 0) {
        break label689;
      }
      this.mMd.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      ae.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.gpr.setVisibility(8);
      break;
      label655:
      this.mMa.setText(getString(2131755460));
      break label446;
      label672:
      this.mMb.setText(getString(2131755461));
    }
    label689:
    if (paramView.HMf.size() == 1)
    {
      this.mMd.setVisibility(0);
      this.mMe.setVisibility(8);
      this.mMg.setVisibility(8);
      if (paramView.HMf.get(0) != null)
      {
        this.mMf.setText(((hg)paramView.HMf.get(0)).name);
        this.mMf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Vy(((hg)paramView.HMf.get(0)).url);
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
      this.mMd.setVisibility(0);
      this.mMe.setVisibility(0);
      this.mMg.setVisibility(0);
      if (paramView.HMf.get(0) != null)
      {
        this.mMf.setText(((hg)paramView.HMf.get(0)).name);
        this.mMf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            ae.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Vy(((hg)paramView.HMf.get(0)).url);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.HMf.get(1) != null)
      {
        this.mMg.setText(((hg)paramView.HMf.get(1)).name);
        this.mMg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/autofill/AppBrandIDCardShowFrag$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Vz(((hg)paramView.HMf.get(1)).url);
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
    if (this.mLX != null) {
      this.mLX.onSwipeBack();
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