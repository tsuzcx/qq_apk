package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.x;
import java.util.LinkedList;

public final class a
  extends x
{
  private LinearLayout dtF;
  private TextView gaI;
  private ImageView heN;
  AppBrandIDCardUI.a heO;
  private View heP;
  private RecyclerView heQ;
  private TextView heR;
  private Button heS;
  private CheckBox heT;
  private TextView heU;
  private LinearLayout heV;
  private View heW;
  private TextView heX;
  private TextView heY;
  private com.tencent.mm.ui.b mActionBarHelper;
  
  protected final void dealContentView(final View paramView)
  {
    if ((this.heO == null) || (this.heO.apo() == null)) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
    }
    label453:
    label485:
    do
    {
      do
      {
        return;
        this.dtF = ((LinearLayout)paramView.findViewById(y.g.app_brand_idcard_show_layout));
        this.heN = ((ImageView)paramView.findViewById(y.g.app_brand_idcard_show_icon));
        this.gaI = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_desc));
        this.heQ = ((RecyclerView)paramView.findViewById(y.g.app_brand_idcard_show_list));
        this.heR = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_busi_desc));
        this.heS = ((Button)paramView.findViewById(y.g.app_brand_idcard_show_confirm));
        this.heT = ((CheckBox)paramView.findViewById(y.g.app_brand_idcard_show_checkbox));
        this.heU = ((TextView)paramView.findViewById(y.g.app_brand_show_protocal));
        this.heV = ((LinearLayout)paramView.findViewById(y.g.app_brand_idcard_show_bottom_layout));
        this.heW = paramView.findViewById(y.g.app_brand_idcard_show_url_line);
        this.heX = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_url_1));
        this.heY = ((TextView)paramView.findViewById(y.g.app_brand_idcard_show_url_2));
        this.heP = com.tencent.mm.ui.y.gt(getContext()).inflate(y.h.actionbar_custom_area, null);
        this.heP.setBackgroundColor(getResources().getColor(y.d.action_bar_color));
        this.mActionBarHelper = new com.tencent.mm.ui.b(this.heP);
        paramView = new LinearLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.cD(getActivity()));
        this.dtF.addView(this.heP, 0, paramView);
        paramView = this.heO.apo();
        this.mActionBarHelper.setTitle(paramView.title);
        this.mActionBarHelper.cxQ();
        Object localObject = getResources().getDrawable(y.i.actionbar_icon_light_back);
        ((Drawable)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        this.mActionBarHelper.s((Drawable)localObject);
        this.mActionBarHelper.d(new a.1(this));
        com.tencent.mm.modelappbrand.a.b.JD().a(this.heN, paramView.tvJ, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
        this.gaI.setText(paramView.dRQ + " " + paramView.tIE);
        if (paramView.tIF != null)
        {
          this.heQ.setVisibility(0);
          localObject = this.heQ;
          getContext();
          ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager());
          this.heQ.setAdapter(new a.a(paramView.tIF));
          this.heR.setText(paramView.tIG);
          if (bk.bl(paramView.tIH)) {
            break label689;
          }
          this.heS.setText(paramView.tIH);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", new Object[] { Boolean.valueOf(paramView.tIL) });
          this.heT.setChecked(paramView.tIL);
          this.heS.setEnabled(paramView.tIL);
          if (bk.bl(paramView.tIM)) {
            break label706;
          }
          this.heT.setText(paramView.tIM);
        }
        for (;;)
        {
          this.heT.setOnCheckedChangeListener(new a.2(this));
          this.heS.setOnClickListener(new a.3(this));
          if (paramView.tII != null)
          {
            this.heU.setText(paramView.tII.name);
            this.heU.setOnClickListener(new a.4(this, paramView));
          }
          if (paramView.tIJ == null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", new Object[] { Integer.valueOf(paramView.tIJ.size()) });
          if (paramView.tIJ.size() != 0) {
            break label723;
          }
          this.heV.setVisibility(8);
          return;
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
          this.heQ.setVisibility(8);
          break label453;
          this.heS.setText(getString(y.j.app_brand_idcard_show_default_confirm_text));
          break label485;
          this.heT.setText(getString(y.j.app_brand_idcard_show_legal_agreement_prefix));
        }
        if (paramView.tIJ.size() != 1) {
          break;
        }
        this.heV.setVisibility(0);
        this.heW.setVisibility(8);
        this.heY.setVisibility(8);
      } while (paramView.tIJ.get(0) == null);
      this.heX.setText(((ew)paramView.tIJ.get(0)).name);
      this.heX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (a.a(a.this) != null) {
            a.a(a.this).ww(((ew)paramView.tIJ.get(0)).url);
          }
        }
      });
      return;
      this.heV.setVisibility(0);
      this.heW.setVisibility(0);
      this.heY.setVisibility(0);
      if (paramView.tIJ.get(0) != null)
      {
        this.heX.setText(((ew)paramView.tIJ.get(0)).name);
        this.heX.setOnClickListener(new a.6(this, paramView));
      }
    } while (paramView.tIJ.get(1) == null);
    label689:
    label706:
    label723:
    this.heY.setText(((ew)paramView.tIJ.get(1)).name);
    this.heY.setOnClickListener(new a.7(this, paramView));
  }
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_idcard_show_ui;
  }
  
  public final boolean noActionBar()
  {
    return true;
  }
  
  public final void onSwipeBack()
  {
    if (this.heO != null) {
      this.heO.onSwipeBack();
    }
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a
 * JD-Core Version:    0.7.0.1
 */