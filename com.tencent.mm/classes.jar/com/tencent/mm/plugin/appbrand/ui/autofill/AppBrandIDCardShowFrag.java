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
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.z;
import java.util.LinkedList;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private ImageView fBA;
  private LinearLayout fBI;
  private RecyclerView fTr;
  private TextView gAI;
  private com.tencent.mm.ui.a mActionBarHelper;
  private View mgA;
  private TextView mgB;
  private TextView mgC;
  AppBrandIDCardUI.a mgt;
  private View mgu;
  private TextView mgv;
  private Button mgw;
  private CheckBox mgx;
  private TextView mgy;
  private LinearLayout mgz;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.mgt == null) || (this.mgt.bvO() == null))
    {
      ac.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.fBI = ((LinearLayout)paramView.findViewById(2131296747));
    this.fBA = ((ImageView)paramView.findViewById(2131296744));
    this.gAI = ((TextView)paramView.findViewById(2131296743));
    this.fTr = ((RecyclerView)paramView.findViewById(2131296749));
    this.mgv = ((TextView)paramView.findViewById(2131296740));
    this.mgw = ((Button)paramView.findViewById(2131296742));
    this.mgx = ((CheckBox)paramView.findViewById(2131296741));
    this.mgy = ((TextView)paramView.findViewById(2131296833));
    this.mgz = ((LinearLayout)paramView.findViewById(2131296739));
    this.mgA = paramView.findViewById(2131296752);
    this.mgB = ((TextView)paramView.findViewById(2131296750));
    this.mgC = ((TextView)paramView.findViewById(2131296751));
    this.mgu = z.jD(getContext()).inflate(2131492921, null);
    this.mgu.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.mgu);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dT(getActivity()));
    this.fBI.addView(this.mgu, 0, paramView);
    paramView = this.mgt.bvO();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(48909);
        if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
          AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).back();
        }
        AppMethodBeat.o(48909);
      }
    });
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.fBA, paramView.FnD, com.tencent.mm.modelappbrand.a.a.aAR(), g.htk);
    this.gAI.setText(paramView.hiX + " " + paramView.FHP);
    if (paramView.FHQ != null)
    {
      this.fTr.setVisibility(0);
      RecyclerView localRecyclerView = this.fTr;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.fTr.setAdapter(new AppBrandIDCardShowFrag.a(paramView.FHQ));
      this.mgv.setText(paramView.FHR);
      if (bs.isNullOrNil(paramView.FHS)) {
        break label655;
      }
      this.mgw.setText(paramView.FHS);
      label446:
      ac.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.FHW) });
      this.mgx.setChecked(paramView.FHW);
      this.mgw.setEnabled(paramView.FHW);
      if (bs.isNullOrNil(paramView.FHX)) {
        break label672;
      }
      this.mgx.setText(paramView.FHX);
    }
    for (;;)
    {
      this.mgx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.mgw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          ac.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).bvM();
          }
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.FHT != null)
      {
        this.mgy.setText(paramView.FHT.name);
        this.mgy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Rg(paramView.FHT.url);
            }
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.FHU == null) {
        break label900;
      }
      ac.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.FHU.size()) });
      if (paramView.FHU.size() != 0) {
        break label689;
      }
      this.mgz.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      ac.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.fTr.setVisibility(8);
      break;
      label655:
      this.mgw.setText(getString(2131755460));
      break label446;
      label672:
      this.mgx.setText(getString(2131755461));
    }
    label689:
    if (paramView.FHU.size() == 1)
    {
      this.mgz.setVisibility(0);
      this.mgA.setVisibility(8);
      this.mgC.setVisibility(8);
      if (paramView.FHU.get(0) != null)
      {
        this.mgB.setText(((gz)paramView.FHU.get(0)).name);
        this.mgB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Rh(((gz)paramView.FHU.get(0)).url);
            }
            AppMethodBeat.o(48913);
          }
        });
        AppMethodBeat.o(48920);
      }
    }
    else
    {
      this.mgz.setVisibility(0);
      this.mgA.setVisibility(0);
      this.mgC.setVisibility(0);
      if (paramView.FHU.get(0) != null)
      {
        this.mgB.setText(((gz)paramView.FHU.get(0)).name);
        this.mgB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            ac.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Rh(((gz)paramView.FHU.get(0)).url);
            }
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.FHU.get(1) != null)
      {
        this.mgC.setText(((gz)paramView.FHU.get(1)).name);
        this.mgC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).Ri(((gz)paramView.FHU.get(1)).url);
            }
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
    if (this.mgt != null) {
      this.mgt.onSwipeBack();
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