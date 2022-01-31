package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.w;
import java.util.LinkedList;
import java.util.List;

public class AppBrandIDCardShowFrag
  extends MMFragment
{
  private LinearLayout elj;
  private TextView hsI;
  AppBrandIDCardUI.a iQb;
  private View iQc;
  private ImageView iQd;
  private RecyclerView iQe;
  private TextView iQf;
  private Button iQg;
  private CheckBox iQh;
  private TextView iQi;
  private LinearLayout iQj;
  private View iQk;
  private TextView iQl;
  private TextView iQm;
  private com.tencent.mm.ui.a mActionBarHelper;
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(133213);
    if ((this.iQb == null) || (this.iQb.aME() == null))
    {
      ab.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
      AppMethodBeat.o(133213);
      return;
    }
    this.elj = ((LinearLayout)paramView.findViewById(2131821225));
    this.iQd = ((ImageView)paramView.findViewById(2131821226));
    this.hsI = ((TextView)paramView.findViewById(2131821227));
    this.iQe = ((RecyclerView)paramView.findViewById(2131821229));
    this.iQf = ((TextView)paramView.findViewById(2131821230));
    this.iQg = ((Button)paramView.findViewById(2131821233));
    this.iQh = ((CheckBox)paramView.findViewById(2131821231));
    this.iQi = ((TextView)paramView.findViewById(2131821232));
    this.iQj = ((LinearLayout)paramView.findViewById(2131821222));
    this.iQk = paramView.findViewById(2131821235);
    this.iQl = ((TextView)paramView.findViewById(2131821234));
    this.iQm = ((TextView)paramView.findViewById(2131821236));
    this.iQc = w.hM(getContext()).inflate(2130968613, null);
    this.iQc.setBackgroundColor(getResources().getColor(2131690316));
    this.mActionBarHelper = new com.tencent.mm.ui.a(this.iQc);
    paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.di(getActivity()));
    this.elj.addView(this.iQc, 0, paramView);
    paramView = this.iQb.aME();
    this.mActionBarHelper.setTitle(paramView.title);
    this.mActionBarHelper.b(new AppBrandIDCardShowFrag.1(this));
    com.tencent.mm.modelappbrand.a.b.acD().a(this.iQd, paramView.xvU, com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
    this.hsI.setText(paramView.fhP + " " + paramView.xMS);
    if (paramView.xMT != null)
    {
      this.iQe.setVisibility(0);
      RecyclerView localRecyclerView = this.iQe;
      getContext();
      localRecyclerView.setLayoutManager(new LinearLayoutManager());
      this.iQe.setAdapter(new a(paramView.xMT));
      this.iQf.setText(paramView.xMU);
      if (bo.isNullOrNil(paramView.xMV)) {
        break label655;
      }
      this.iQg.setText(paramView.xMV);
      label446:
      ab.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.xMZ) });
      this.iQh.setChecked(paramView.xMZ);
      this.iQg.setEnabled(paramView.xMZ);
      if (bo.isNullOrNil(paramView.xNa)) {
        break label672;
      }
      this.iQh.setText(paramView.xNa);
    }
    for (;;)
    {
      this.iQh.setOnCheckedChangeListener(new AppBrandIDCardShowFrag.2(this));
      this.iQg.setOnClickListener(new AppBrandIDCardShowFrag.3(this));
      if (paramView.xMW != null)
      {
        this.iQi.setText(paramView.xMW.name);
        this.iQi.setOnClickListener(new AppBrandIDCardShowFrag.4(this, paramView));
      }
      if (paramView.xMX == null) {
        break label900;
      }
      ab.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.xMX.size()) });
      if (paramView.xMX.size() != 0) {
        break label689;
      }
      this.iQj.setVisibility(8);
      AppMethodBeat.o(133213);
      return;
      ab.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
      this.iQe.setVisibility(8);
      break;
      label655:
      this.iQg.setText(getString(2131296679));
      break label446;
      label672:
      this.iQh.setText(getString(2131296680));
    }
    label689:
    if (paramView.xMX.size() == 1)
    {
      this.iQj.setVisibility(0);
      this.iQk.setVisibility(8);
      this.iQm.setVisibility(8);
      if (paramView.xMX.get(0) != null)
      {
        this.iQl.setText(((ga)paramView.xMX.get(0)).name);
        this.iQl.setOnClickListener(new AppBrandIDCardShowFrag.5(this, paramView));
        AppMethodBeat.o(133213);
      }
    }
    else
    {
      this.iQj.setVisibility(0);
      this.iQk.setVisibility(0);
      this.iQm.setVisibility(0);
      if (paramView.xMX.get(0) != null)
      {
        this.iQl.setText(((ga)paramView.xMX.get(0)).name);
        this.iQl.setOnClickListener(new AppBrandIDCardShowFrag.6(this, paramView));
      }
      if (paramView.xMX.get(1) != null)
      {
        this.iQm.setText(((ga)paramView.xMX.get(1)).name);
        this.iQm.setOnClickListener(new AppBrandIDCardShowFrag.7(this, paramView));
      }
    }
    label900:
    AppMethodBeat.o(133213);
  }
  
  public int getLayoutId()
  {
    return 2130968690;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(133214);
    if (this.iQb != null) {
      this.iQb.onSwipeBack();
    }
    AppMethodBeat.o(133214);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  public static final class a
    extends RecyclerView.a<AppBrandIDCardShowFrag.a.a>
  {
    private List<fz> iQp;
    
    public a(List<fz> paramList)
    {
      this.iQp = paramList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(133210);
      if (this.iQp == null)
      {
        AppMethodBeat.o(133210);
        return 0;
      }
      int i = this.iQp.size();
      AppMethodBeat.o(133210);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag
 * JD-Core Version:    0.7.0.1
 */