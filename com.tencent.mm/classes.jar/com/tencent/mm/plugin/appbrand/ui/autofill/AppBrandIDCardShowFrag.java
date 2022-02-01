package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.protocal.protobuf.gv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private RecyclerView fPw;
  private ImageView fxT;
  private LinearLayout fyb;
  private TextView lEA;
  private TextView lEB;
  private Button lEC;
  private CheckBox lED;
  private TextView lEE;
  private LinearLayout lEF;
  private View lEG;
  private TextView lEH;
  private TextView lEI;
  AppBrandIDCardUI.a lEy;
  private View lEz;
  private com.tencent.mm.ui.a mActionBarHelper;
  
  public void dealContentView(final View paramView)
  {
    AppMethodBeat.i(48920);
    if ((this.lEy == null) || (this.lEy.boT() == null))
    {
      ad.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(48920);
      return;
    }
    this.fyb = ((LinearLayout)paramView.findViewById(2131296747));
    this.fxT = ((ImageView)paramView.findViewById(2131296744));
    this.lEA = ((TextView)paramView.findViewById(2131296743));
    this.fPw = ((RecyclerView)paramView.findViewById(2131296749));
    this.lEB = ((TextView)paramView.findViewById(2131296740));
    this.lEC = ((Button)paramView.findViewById(2131296742));
    this.lED = ((CheckBox)paramView.findViewById(2131296741));
    this.lEE = ((TextView)paramView.findViewById(2131296833));
    this.lEF = ((LinearLayout)paramView.findViewById(2131296739));
    this.lEG = paramView.findViewById(2131296752);
    this.lEH = ((TextView)paramView.findViewById(2131296750));
    this.lEI = ((TextView)paramView.findViewById(2131296751));
    this.lEz = y.js(getContext()).inflate(2131492921, null);
    this.lEz.setBackgroundColor(getResources().getColor(2131100705));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.lEz);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dL(getActivity()));
    this.fyb.addView(this.lEz, 0, paramView);
    paramView = this.lEy.boT();
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
    com.tencent.mm.modelappbrand.a.b.aub().a(this.fxT, paramView.DRl, com.tencent.mm.modelappbrand.a.a.aua(), g.gSK);
    this.lEA.setText(paramView.gIw + " " + paramView.EkR);
    if (paramView.EkS != null)
    {
      this.fPw.setVisibility(0);
      RecyclerView localRecyclerView = this.fPw;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.fPw.setAdapter(new a(paramView.EkS));
      this.lEB.setText(paramView.EkT);
      if (bt.isNullOrNil(paramView.EkU)) {
        break label655;
      }
      this.lEC.setText(paramView.EkU);
      label446:
      ad.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.EkY) });
      this.lED.setChecked(paramView.EkY);
      this.lEC.setEnabled(paramView.EkY);
      if (bt.isNullOrNil(paramView.EkZ)) {
        break label672;
      }
      this.lED.setText(paramView.EkZ);
    }
    for (;;)
    {
      this.lED.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
      this.lEC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(48911);
          ad.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
          if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
            AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).boR();
          }
          AppMethodBeat.o(48911);
        }
      });
      if (paramView.EkV != null)
      {
        this.lEE.setText(paramView.EkV.name);
        this.lEE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48912);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).MX(paramView.EkV.url);
            }
            AppMethodBeat.o(48912);
          }
        });
      }
      if (paramView.EkW == null) {
        break label900;
      }
      ad.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.EkW.size()) });
      if (paramView.EkW.size() != 0) {
        break label689;
      }
      this.lEF.setVisibility(8);
      AppMethodBeat.o(48920);
      return;
      ad.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.fPw.setVisibility(8);
      break;
      label655:
      this.lEC.setText(getString(2131755460));
      break label446;
      label672:
      this.lED.setText(getString(2131755461));
    }
    label689:
    if (paramView.EkW.size() == 1)
    {
      this.lEF.setVisibility(0);
      this.lEG.setVisibility(8);
      this.lEI.setVisibility(8);
      if (paramView.EkW.get(0) != null)
      {
        this.lEH.setText(((gv)paramView.EkW.get(0)).name);
        this.lEH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48913);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).MY(((gv)paramView.EkW.get(0)).url);
            }
            AppMethodBeat.o(48913);
          }
        });
        AppMethodBeat.o(48920);
      }
    }
    else
    {
      this.lEF.setVisibility(0);
      this.lEG.setVisibility(0);
      this.lEI.setVisibility(0);
      if (paramView.EkW.get(0) != null)
      {
        this.lEH.setText(((gv)paramView.EkW.get(0)).name);
        this.lEH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48914);
            ad.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).MY(((gv)paramView.EkW.get(0)).url);
            }
            AppMethodBeat.o(48914);
          }
        });
      }
      if (paramView.EkW.get(1) != null)
      {
        this.lEI.setText(((gv)paramView.EkW.get(1)).name);
        this.lEI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(48915);
            if (AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this) != null) {
              AppBrandIDCardShowFrag.a(AppBrandIDCardShowFrag.this).MZ(((gv)paramView.EkW.get(1)).url);
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
    if (this.lEy != null) {
      this.lEy.onSwipeBack();
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
    private List<gu> lEL;
    
    public a(List<gu> paramList)
    {
      this.lEL = paramList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(48917);
      if (this.lEL == null)
      {
        AppMethodBeat.o(48917);
        return 0;
      }
      int i = this.lEL.size();
      AppMethodBeat.o(48917);
      return i;
    }
    
    public static final class a
      extends RecyclerView.v
    {
      public TextView ftj;
      public TextView lEM;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(48916);
        this.ftj = ((TextView)paramView.findViewById(2131296745));
        this.lEM = ((TextView)paramView.findViewById(2131296746));
        AppMethodBeat.o(48916);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */