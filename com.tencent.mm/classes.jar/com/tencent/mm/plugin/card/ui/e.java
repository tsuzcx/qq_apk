package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.a;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e
  implements g.a, n, MMActivity.a
{
  private final String TAG;
  boolean cvo;
  LinearLayout eM;
  View.OnClickListener gMO;
  private View iCk;
  com.tencent.mm.plugin.card.base.b klk;
  List<com.tencent.mm.plugin.card.model.b> klo;
  ArrayList<oz> klq;
  public int kre;
  String krf;
  String krg;
  public ArrayList<String> krh;
  public ArrayList<String> kri;
  m ktA;
  i ktB;
  i ktC;
  i ktD;
  i ktE;
  i ktF;
  i ktG;
  i ktH;
  i ktI;
  com.tencent.mm.plugin.card.ui.view.d ktJ;
  i ktK;
  j ktL;
  boolean ktM;
  com.tencent.mm.plugin.card.b.f ktN;
  public String ktO;
  public String ktP;
  HashMap<Integer, String> ktQ;
  HashMap<String, String> ktR;
  ArrayList<String> ktS;
  e.d ktT;
  e.a ktU;
  private ak ktV;
  com.tencent.mm.sdk.b.c ktW;
  CardDetailBaseUI kts;
  com.tencent.mm.plugin.card.ui.a.g ktt;
  i ktu;
  boolean ktv;
  i ktw;
  i ktx;
  com.tencent.mm.plugin.card.widget.g kty;
  com.tencent.mm.plugin.card.ui.view.g ktz;
  ListView mListView;
  
  public e(CardDetailBaseUI paramCardDetailBaseUI, View paramView)
  {
    AppMethodBeat.i(88349);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.ktv = false;
    this.ktM = true;
    this.klo = new ArrayList();
    this.ktO = "";
    this.ktP = "";
    this.kre = 0;
    this.krf = "";
    this.krg = "";
    this.krh = new ArrayList();
    this.kri = new ArrayList();
    this.ktQ = new HashMap();
    this.ktR = new HashMap();
    this.ktS = new ArrayList();
    this.cvo = false;
    this.ktV = new e.3(this);
    this.gMO = new e.4(this);
    this.ktW = new e.7(this);
    this.kts = paramCardDetailBaseUI;
    this.iCk = paramView;
    AppMethodBeat.o(88349);
  }
  
  private void If(String paramString)
  {
    AppMethodBeat.i(88377);
    Intent localIntent = new Intent();
    if ((this.klk instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.klk);
    }
    for (;;)
    {
      localIntent.setClass(this.kts, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.ktU.ejF);
      localIntent.putExtra("key_previous_scene", this.ktU.kqC);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.ktU.kua);
      this.kts.startActivityForResult(localIntent, 3);
      this.kts.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(88377);
      return;
      if ((this.klk instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.klk);
      }
    }
  }
  
  private String bcK()
  {
    AppMethodBeat.i(88376);
    String str;
    if ((!TextUtils.isEmpty(this.krf)) && (!TextUtils.isEmpty(this.krg)))
    {
      str = this.krf + "," + com.tencent.mm.plugin.card.d.l.IE(this.krg);
      AppMethodBeat.o(88376);
      return str;
    }
    if (!TextUtils.isEmpty(this.krf))
    {
      str = this.krf;
      AppMethodBeat.o(88376);
      return str;
    }
    if (!TextUtils.isEmpty(this.krg))
    {
      str = com.tencent.mm.plugin.card.d.l.IE(this.krg);
      AppMethodBeat.o(88376);
      return str;
    }
    AppMethodBeat.o(88376);
    return "";
  }
  
  private void bdF()
  {
    AppMethodBeat.i(88353);
    int i;
    if (this.ktt == null)
    {
      i = 0;
      if (i != 0)
      {
        this.ktt.release();
        this.ktt = null;
        ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.klk.bbd().iFL) });
      }
      if (this.ktt == null)
      {
        ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.klk.bbd().iFL) });
        ab.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.klk.bbd().iFL) });
        if (!this.klk.baK()) {
          break label423;
        }
        this.ktt = new com.tencent.mm.plugin.card.ui.a.h(this.kts);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.klk.bbd().iFL) });
      this.ktt.a(this.klk, this.ktU);
      AppMethodBeat.o(88353);
      return;
      if (this.klk.baK())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.klk.baL())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.klk.baO())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.klk.baM())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.klk.baN())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.klk.baP())
      {
        if ((this.ktt instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.ktt instanceof a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.klk.bbd().iFL)
      {
      default: 
        this.ktt = new a(this.kts);
        break;
      case 0: 
        this.ktt = new com.tencent.mm.plugin.card.ui.a.c(this.kts);
        break;
      case 10: 
        this.ktt = new com.tencent.mm.plugin.card.ui.a.e(this.kts);
        break;
      case 11: 
        this.ktt = new com.tencent.mm.plugin.card.ui.a.b(this.kts);
        break;
      case 20: 
        this.ktt = new com.tencent.mm.plugin.card.ui.a.f(this.kts);
        break;
      case 30: 
        this.ktt = new com.tencent.mm.plugin.card.ui.a.d(this.kts);
      }
    }
  }
  
  private void bdG()
  {
    AppMethodBeat.i(88359);
    if ((this.klk.bbd().wGE != null) && (this.klk.bbd().wGE.wPY))
    {
      this.ktz = new com.tencent.mm.plugin.card.ui.view.m();
      am.bct().a(this);
      AppMethodBeat.o(88359);
      return;
    }
    if (this.klk.bbd().iFL == 10)
    {
      this.ktz = new q();
      AppMethodBeat.o(88359);
      return;
    }
    this.ktz = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(88359);
  }
  
  private void bdH()
  {
    AppMethodBeat.i(88360);
    if (this.cvo)
    {
      ab.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(88360);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label186:
    Object localObject3;
    int i;
    if ((this.klk.baJ()) && (this.klk.baL()))
    {
      this.iCk.findViewById(2131822070).setBackgroundColor(this.kts.getResources().getColor(2131689824));
      this.kts.Q(-1, true);
      localObject2 = this.iCk.findViewById(2131822074);
      localObject1 = this.iCk.findViewById(2131822075);
      localView = this.iCk.findViewById(2131822076);
      if ((!this.klk.baJ()) || (!this.ktt.beO())) {
        break label1257;
      }
      if (!this.klk.baM()) {
        break label1123;
      }
      ((View)localObject2).setBackgroundResource(2130838182);
      this.iCk.findViewById(2131824304).setBackgroundResource(2130838128);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.klk.baP())
      {
        localObject3 = (TextView)this.iCk.findViewById(2131822092);
        localObject4 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.Na(2130838179));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.klk.baK()) && (this.ktt.beM()) && (this.ktv))
      {
        localObject4 = this.iCk.findViewById(2131822369);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.klk.baJ()) && (this.ktt.beO()))
      {
        localObject4 = this.iCk.findViewById(2131824304);
        ((Rect)localObject3).left = this.kts.getResources().getDimensionPixelOffset(2131427772);
        ((Rect)localObject3).right = this.kts.getResources().getDimensionPixelOffset(2131427772);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.klk.baN())
        {
          localObject3 = this.iCk.findViewById(2131822072);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.kts.getResources().getDimensionPixelSize(2131427854);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.ktt.beO()) && (!this.ktt.beM())) {
        break label1481;
      }
      if ((this.kty != null) && (((this.klk.baJ()) && (this.klk.baM())) || (this.klk.baK()))) {
        this.kty.tw(0);
      }
      label639:
      if ((this.kty != null) && (this.klk.baJ()) && (this.klk.baL()))
      {
        i = this.kts.getResources().getDimensionPixelOffset(2131428184);
        localObject3 = com.tencent.mm.plugin.card.d.l.dR(com.tencent.mm.plugin.card.d.l.IB(this.klk.bbd().color), i);
        this.kty.a((ShapeDrawable)localObject3);
      }
      if ((this.klk.baJ()) && (this.klk.baL()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.klk.bbd().wGk)) {
          break label1566;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label805:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.kts.getResources().getDimensionPixelSize(2131427792);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.klk.baL()) {
          break label1581;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.kts.getResources().getDimensionPixelSize(2131427781);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.kts.getResources().getDimensionPixelSize(2131427782);
        i = this.kts.getResources().getDimensionPixelSize(2131427775);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label921:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.klk.baL()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.kts.getResources().getDimensionPixelSize(2131427775);
        }
        if (TextUtils.isEmpty(this.klk.bbd().wGk)) {
          break label1610;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.klk.bbd().wGk))
      {
        localView = findViewById(2131822093);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.iCk.invalidate();
      AppMethodBeat.o(88360);
      return;
      i = com.tencent.mm.plugin.card.d.l.IB(this.klk.bbd().color);
      this.iCk.findViewById(2131822070).setBackgroundColor(i);
      this.kts.Q(i, false);
      break;
      label1123:
      if (this.klk.baL())
      {
        this.iCk.findViewById(2131824304).setBackgroundResource(0);
        localView.setBackgroundColor(this.kts.getResources().getColor(2131689824));
        break label186;
      }
      if (this.klk.baN())
      {
        ((View)localObject2).setBackgroundResource(2130838182);
        this.iCk.findViewById(2131824304).setBackgroundResource(2130838128);
        localView.setBackgroundResource(0);
        break label186;
      }
      if ((this.klk.baO()) || (!this.klk.baP())) {
        break label186;
      }
      localView.setBackgroundColor(this.kts.getResources().getColor(2131689824));
      break label186;
      label1257:
      if (this.klk.baK())
      {
        if ((this.ktt.beM()) && (this.ktv))
        {
          ((View)localObject2).setBackgroundResource(2130838182);
          localView.setBackgroundResource(0);
          break label186;
        }
        if ((this.ktt.beM()) && (!this.ktv))
        {
          ((View)localObject2).setBackgroundResource(2130838180);
          localView.setBackgroundResource(0);
          break label186;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.ktt.bdT())
        {
          localView.setBackgroundResource(2130838180);
          break label186;
        }
        localView.setBackgroundResource(2130838182);
        break label186;
      }
      if (this.klk.baM())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.ktt.bdT())
        {
          localView.setBackgroundResource(2130838180);
          break label186;
        }
        localView.setBackgroundResource(2130838182);
        break label186;
      }
      if (this.klk.baN())
      {
        ((View)localObject2).setBackgroundResource(2130838185);
        localView.setBackgroundResource(0);
        break label186;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.kts.getResources().getColor(2131689824));
      break label186;
      label1481:
      if ((this.kty == null) || (((!this.klk.baJ()) || (!this.klk.baM())) && (!this.klk.baK()))) {
        break label639;
      }
      if (this.ktt.bdT())
      {
        this.kty.tw(2130838183);
        break label639;
      }
      this.kty.tw(2130838181);
      break label639;
      label1566:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label805;
      label1581:
      i = this.kts.getResources().getDimensionPixelSize(2131427506);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label921;
      label1610:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void bdI()
  {
    AppMethodBeat.i(88364);
    if (!this.ktt.beQ())
    {
      ab.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(88364);
      return;
    }
    this.klo.clear();
    this.klo.addAll(this.ktN.bbE());
    this.ktA.setData(this.klo);
    this.ktA.kyr = this.klk.baP();
    this.ktA.notifyDataSetChanged();
    AppMethodBeat.o(88364);
  }
  
  private void bdJ()
  {
    AppMethodBeat.i(88365);
    if (this.klk == null)
    {
      ab.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(88365);
      return;
    }
    if (bdK()) {
      bdM();
    }
    if (this.kty == null) {
      bdL();
    }
    if (this.kty != null)
    {
      if (this.klk.baN()) {
        ((com.tencent.mm.plugin.card.widget.f)this.kty).klq = this.klq;
      }
      this.kty.d(this.klk);
    }
    AppMethodBeat.o(88365);
  }
  
  private boolean bdK()
  {
    AppMethodBeat.i(88366);
    if (this.kty == null)
    {
      AppMethodBeat.o(88366);
      return false;
    }
    if (this.klk.baL())
    {
      if ((this.kty instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(88366);
        return false;
      }
      AppMethodBeat.o(88366);
      return true;
    }
    if (this.klk.baO())
    {
      if ((this.kty instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(88366);
        return false;
      }
      AppMethodBeat.o(88366);
      return true;
    }
    if (this.klk.baM())
    {
      if ((this.kty instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(88366);
        return false;
      }
      AppMethodBeat.o(88366);
      return true;
    }
    if (this.klk.baN())
    {
      if ((this.kty instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(88366);
        return false;
      }
      AppMethodBeat.o(88366);
      return true;
    }
    if (this.klk.baP())
    {
      if ((this.kty instanceof com.tencent.mm.plugin.card.widget.d))
      {
        AppMethodBeat.o(88366);
        return false;
      }
      AppMethodBeat.o(88366);
      return true;
    }
    AppMethodBeat.o(88366);
    return false;
  }
  
  private void bdL()
  {
    AppMethodBeat.i(88367);
    if (this.klk.baL()) {
      this.kty = new com.tencent.mm.plugin.card.widget.e(this.kts);
    }
    for (;;)
    {
      this.kty.i(this.klk);
      View localView = this.kty.hv();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.m.a(localView, this.eM);
      }
      this.eM.invalidate();
      this.kty.setOnClickListener(this.gMO);
      x(false, false);
      AppMethodBeat.o(88367);
      return;
      if (this.klk.baO()) {
        this.kty = new com.tencent.mm.plugin.card.widget.c(this.kts);
      } else if (this.klk.baM()) {
        this.kty = new com.tencent.mm.plugin.card.widget.b(this.kts);
      } else if (this.klk.baN()) {
        this.kty = new com.tencent.mm.plugin.card.widget.f(this.kts);
      } else if (this.klk.baP()) {
        this.kty = new com.tencent.mm.plugin.card.widget.d(this.kts);
      } else {
        this.kty = new com.tencent.mm.plugin.card.widget.b(this.kts);
      }
    }
  }
  
  private void bdM()
  {
    AppMethodBeat.i(88368);
    View localView = this.kty.hv();
    if (localView != null) {
      this.eM.removeView(localView);
    }
    this.eM.removeAllViews();
    this.eM.invalidate();
    this.kty.release();
    this.kty = null;
    AppMethodBeat.o(88368);
  }
  
  private void bdN()
  {
    AppMethodBeat.i(88369);
    if ((this.kty != null) && ((this.kty instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.kty).bdN();
    }
    AppMethodBeat.o(88369);
  }
  
  private void bdO()
  {
    AppMethodBeat.i(88370);
    oj localoj = this.klk.bbe();
    this.klk.a(localoj);
    com.tencent.mm.plugin.card.d.l.h(this.klk);
    AppMethodBeat.o(88370);
  }
  
  private void bdP()
  {
    int i = 0;
    AppMethodBeat.i(88371);
    this.ktQ.clear();
    this.ktS.clear();
    if (this.klk.baS())
    {
      this.ktS.add(getString(2131298087));
      this.ktQ.put(Integer.valueOf(0), "menu_func_share_friend");
      this.ktS.add(getString(2131298086));
      this.ktQ.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.klk.bbe().wDX))
    {
      this.ktS.add(getString(2131297996));
      this.ktQ.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    tj(j);
    if (this.ktS.size() > 0) {
      this.kts.fY(true);
    }
    AppMethodBeat.o(88371);
  }
  
  private void bdQ()
  {
    int j = 0;
    AppMethodBeat.i(88372);
    this.ktQ.clear();
    this.ktS.clear();
    int i = j;
    if (this.klk.baJ())
    {
      i = j;
      if (this.klk.baR())
      {
        if (bo.isNullOrNil(this.klk.bbd().wGL)) {
          break label235;
        }
        this.ktS.add(this.klk.bbd().wGL);
        this.ktQ.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.klk.bbe().wDX))
    {
      this.ktS.add(getString(2131297996));
      this.ktQ.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.klk.baJ())
    {
      this.ktS.add(getString(2131296901));
      this.ktQ.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      tj(i);
      if (this.ktS.size() > 0) {
        this.kts.fY(true);
      }
      AppMethodBeat.o(88372);
      return;
      label235:
      if (this.klk.baP())
      {
        this.ktS.add(getString(2131297995));
        break;
      }
      this.ktS.add(getString(2131297994));
      break;
      i = j;
      if (this.klk.baK())
      {
        String str1 = r.Zn();
        String str2 = this.klk.bbj();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.ktS.add(getString(2131296901));
          this.ktQ.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          ab.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void bdR()
  {
    int i = 0;
    AppMethodBeat.i(88373);
    this.ktQ.clear();
    this.ktS.clear();
    if (!TextUtils.isEmpty(this.klk.bbe().wDX))
    {
      this.ktS.add(getString(2131297996));
      this.ktQ.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    tj(i);
    if (this.ktS.size() > 0) {
      this.kts.fY(true);
    }
    AppMethodBeat.o(88373);
  }
  
  private void tj(int paramInt)
  {
    AppMethodBeat.i(88374);
    LinkedList localLinkedList = this.klk.bbe().wDZ;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(88374);
      return;
    }
    this.ktR.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      ax localax = (ax)localLinkedList.get(paramInt);
      j = i;
      if (!bo.isNullOrNil(localax.text))
      {
        j = i;
        if (!bo.isNullOrNil(localax.url))
        {
          this.ktS.add(localax.text);
          this.ktQ.put(Integer.valueOf(i), localax.text);
          this.ktR.put(localax.text, localax.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(88374);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(88363);
    if (!this.ktt.beL())
    {
      this.kts.setMMTitle("");
      AppMethodBeat.o(88363);
      return;
    }
    this.kts.setMMTitle(this.ktN.getTitle());
    AppMethodBeat.o(88363);
  }
  
  private void x(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(88362);
    if (this.kty != null) {
      this.kty.x(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(88362);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, e.a parama, ArrayList<oz> paramArrayList)
  {
    this.klk = paramb;
    this.ktU = parama;
    this.klq = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(88361);
    if (paramBoolean1)
    {
      localObject1 = this.klk.bbe().wEb;
      if (this.klk.baX())
      {
        com.tencent.mm.plugin.card.d.b.a(this.kts, paramb.kmb, paramb.kmc, paramBoolean2, this.klk);
        com.tencent.mm.plugin.report.service.h.qsU.e(11941, new Object[] { Integer.valueOf(17), this.klk.bbh(), this.klk.bbi(), "", this.klk.bbe().wEb.title });
        AppMethodBeat.o(88361);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((uo)localObject1).wFL)) && (!TextUtils.isEmpty(((uo)localObject1).wFM)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.klk.bbh(), (uo)localObject1, this.ktU.kqC, this.ktU.kua);
        localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
        str1 = this.klk.bbh();
        str2 = this.klk.bbi();
        if (((uo)localObject1).title != null) {}
        for (paramb = ((uo)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).e(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(88361);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((uo)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.H(((uo)localObject1).url, ((uo)localObject1).wGZ);
        com.tencent.mm.plugin.card.d.b.a(this.kts, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
        str1 = this.klk.bbh();
        str2 = this.klk.bbi();
        if (((uo)localObject1).title != null) {}
        for (paramb = ((uo)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).e(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(88361);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      j = this.klk.bbd().iFL;
      localObject2 = this.klk.bbi();
      str1 = this.klk.bbh();
      k = this.ktU.kqC;
      str2 = this.ktU.ktc;
      if (this.klk.bbb()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).e(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        If(paramb.klY);
        AppMethodBeat.o(88361);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
    int k = this.klk.bbd().iFL;
    Object localObject2 = this.klk.bbi();
    String str1 = this.klk.bbh();
    int m = this.ktU.kqC;
    String str2 = this.ktU.ktc;
    if (this.klk.bbb()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).e(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      If(paramb.klY);
      AppMethodBeat.o(88361);
      return;
    }
  }
  
  public final void ap(int paramInt, String paramString)
  {
    AppMethodBeat.i(88356);
    ab.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    e.c localc = new e.c((byte)0);
    localc.kug = e.b.kue;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131297910);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.ktV.sendMessage(localMessage);
      AppMethodBeat.o(88356);
      return;
      if (paramInt == 2) {
        paramString = getString(2131297879);
      } else {
        paramString = getString(2131297909);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(88351);
    if (paramb != null)
    {
      this.klk = paramb;
      if (this.ktT != null) {
        this.ktT.b(paramb);
      }
      bcI();
    }
    AppMethodBeat.o(88351);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(88358);
    ab.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    e.c localc = new e.c((byte)0);
    localc.kug = e.b.kud;
    localc.kuh = paramc;
    localMessage.obj = localc;
    this.ktV.sendMessage(localMessage);
    AppMethodBeat.o(88358);
  }
  
  public final void bbI()
  {
    AppMethodBeat.i(88357);
    ab.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    e.c localc = new e.c((byte)0);
    localc.kug = e.b.kuc;
    localMessage.obj = localc;
    this.ktV.sendMessage(localMessage);
    AppMethodBeat.o(88357);
  }
  
  public final void bcI()
  {
    AppMethodBeat.i(88354);
    if (this.klk == null)
    {
      ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.ktT != null) {
        this.ktT.bds();
      }
      AppMethodBeat.o(88354);
      return;
    }
    if (this.klk.bbd() == null)
    {
      ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.ktT != null) {
        this.ktT.bds();
      }
      AppMethodBeat.o(88354);
      return;
    }
    if (this.klk.bbe() == null)
    {
      ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.ktT != null) {
        this.ktT.bds();
      }
      AppMethodBeat.o(88354);
      return;
    }
    if (!this.klk.baQ())
    {
      ab.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.klk.bbd().iFL) });
      if (!TextUtils.isEmpty(this.klk.bbd().wGf))
      {
        com.tencent.mm.plugin.card.d.b.a(this.kts, this.klk.bbd().wGf, 0);
        if (this.ktT != null)
        {
          this.ktT.bds();
          AppMethodBeat.o(88354);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.kts, getString(2131298005), null, false, new e.2(this));
      }
      AppMethodBeat.o(88354);
      return;
    }
    ab.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    ab.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.klk.bbd().wGA);
    this.ktN.a(this.klk, this.klq, this.ktU.ejF);
    bdF();
    this.ktt.bfd();
    ab.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    bdJ();
    if (this.ktt.beM())
    {
      ab.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.ktu.update();
      if (!this.ktt.beD()) {
        break label1156;
      }
      if (this.ktK == null)
      {
        this.ktK = new com.tencent.mm.plugin.card.ui.view.b();
        this.ktK.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.ktK.update();
      label436:
      this.kts.fY(this.ktt.beH());
      if (this.ktt.beI()) {
        bdP();
      }
      if (this.ktt.beJ()) {
        bdQ();
      }
      if (this.ktt.beK()) {
        bdR();
      }
      bdN();
      x(this.ktt.beF(), this.ktt.beG());
      if ((this.klk.baL()) || (!this.ktt.beO())) {
        break label1181;
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.ktw.update();
      label565:
      if (this.kty != null) {
        this.kty.gd(this.ktt.bdT());
      }
      bdH();
      if (!this.ktt.beT()) {
        break label1278;
      }
      if (this.ktC == null)
      {
        this.ktC = new y();
        this.ktC.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.ktC.update();
      label647:
      if (!this.ktt.bfc()) {
        break label1303;
      }
      if (this.ktB == null)
      {
        this.ktB = new com.tencent.mm.plugin.card.ui.view.c();
        this.ktB.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.ktB.update();
      label700:
      if (!this.ktt.beU()) {
        break label1328;
      }
      if (this.ktD == null)
      {
        this.ktD = new k();
        this.ktD.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.ktD.update();
      label753:
      if (!this.ktt.beV()) {
        break label1353;
      }
      if (this.ktE == null)
      {
        this.ktE = new w();
        this.ktE.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.ktE.update();
      label806:
      if (!this.ktt.beW()) {
        break label1378;
      }
      if (this.ktF == null)
      {
        this.ktF = new com.tencent.mm.plugin.card.ui.view.l();
        this.ktF.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.ktF.update();
      label859:
      if (!this.ktt.beX()) {
        break label1403;
      }
      if (this.ktG == null)
      {
        this.ktG = new z();
        this.ktG.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.ktG.update();
      label912:
      if (!this.ktt.beZ()) {
        break label1428;
      }
      if (this.ktH == null)
      {
        this.ktH = new com.tencent.mm.plugin.card.ui.view.e();
        this.ktH.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.ktH.update();
      label965:
      if (!this.ktt.beY()) {
        break label1453;
      }
      if (this.ktI == null)
      {
        this.ktI = new u();
        this.ktI.a(this);
      }
      ab.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.ktI.update();
      label1018:
      bdI();
      if (!this.ktt.beR()) {
        break label1530;
      }
      bdO();
      if (!this.ktt.beS()) {
        break label1513;
      }
      if (this.ktz != null) {
        break label1478;
      }
      bdG();
      this.ktz.a(this);
      this.ktz.update();
      label1076:
      if (this.kty != null) {
        this.kty.gc(true);
      }
      label1093:
      if (!this.ktt.bfa()) {
        break label1572;
      }
      ab.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.ktJ.update();
    }
    for (;;)
    {
      this.ktL.klk = this.klk;
      AppMethodBeat.o(88354);
      return;
      ab.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.ktu.bfq();
      break;
      label1156:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.ktK == null) {
        break label436;
      }
      this.ktK.bfq();
      break label436;
      label1181:
      if ((this.klk.baL()) && (this.ktt.beO()))
      {
        ab.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.ktx.update();
        break label565;
      }
      if (this.ktt.beP())
      {
        ab.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.ktx.update();
        break label565;
      }
      ab.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.ktx.bfq();
      this.ktw.bfq();
      break label565;
      label1278:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.ktC == null) {
        break label647;
      }
      this.ktC.bfq();
      break label647;
      label1303:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.ktB == null) {
        break label700;
      }
      this.ktB.bfq();
      break label700;
      label1328:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.ktD == null) {
        break label753;
      }
      this.ktD.bfq();
      break label753;
      label1353:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.ktE == null) {
        break label806;
      }
      this.ktE.bfq();
      break label806;
      label1378:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.ktF == null) {
        break label859;
      }
      this.ktF.bfq();
      break label859;
      label1403:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.ktG == null) {
        break label912;
      }
      this.ktG.bfq();
      break label912;
      label1428:
      ab.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.ktH == null) {
        break label965;
      }
      this.ktH.bfq();
      break label965;
      label1453:
      ab.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.ktI == null) {
        break label1018;
      }
      this.ktI.bfq();
      break label1018;
      label1478:
      if (!this.ktz.f(this.klk)) {
        break label1076;
      }
      this.ktz.b(this.klk);
      this.ktz.update();
      break label1076;
      label1513:
      if (this.ktz == null) {
        break label1076;
      }
      this.ktz.bfv();
      break label1076;
      label1530:
      ab.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.ktz != null) {
        this.ktz.bfv();
      }
      if (this.kty == null) {
        break label1093;
      }
      this.kty.gc(false);
      break label1093;
      label1572:
      ab.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.ktJ.bfq();
    }
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g bdA()
  {
    return this.ktt;
  }
  
  public final e.d bdB()
  {
    return this.ktT;
  }
  
  public final e.a bdC()
  {
    return this.ktU;
  }
  
  public final com.tencent.mm.plugin.card.b.f bdD()
  {
    return this.ktN;
  }
  
  public final j bdE()
  {
    return this.ktL;
  }
  
  public final int bdS()
  {
    AppMethodBeat.i(88378);
    if (this.ktN == null)
    {
      AppMethodBeat.o(88378);
      return 0;
    }
    if (this.ktN.bbG())
    {
      AppMethodBeat.o(88378);
      return 1;
    }
    AppMethodBeat.o(88378);
    return 0;
  }
  
  public final boolean bdT()
  {
    AppMethodBeat.i(88379);
    if (this.ktt == null)
    {
      AppMethodBeat.o(88379);
      return false;
    }
    boolean bool = this.ktt.bdT();
    AppMethodBeat.o(88379);
    return bool;
  }
  
  public final com.tencent.mm.plugin.card.base.b bdv()
  {
    return this.klk;
  }
  
  public final boolean bdw()
  {
    return this.ktv;
  }
  
  public final void bdx()
  {
    this.ktv = false;
  }
  
  public final MMActivity bdy()
  {
    return this.kts;
  }
  
  public final View.OnClickListener bdz()
  {
    return this.gMO;
  }
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(88375);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88375);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.ktO = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.ktO;
        if ((this.klk == null) || (this.klk.bbd() == null))
        {
          ab.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(88375);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.klk.bbf().xMB)) && (!this.klk.baP())) {
            localStringBuilder.append(this.klk.bbf().xMB);
          }
        }
        for (;;)
        {
          String str = this.klk.bbd().title + "\n" + this.klk.bbd().knw;
          t.a.vUz.a(this.kts.getController(), localStringBuilder.toString(), this.klk.bbd().kmm, str, true, this.kts.getResources().getString(2131297067), new e.6(this, paramInt1, paramIntent));
          AppMethodBeat.o(88375);
          return;
          localStringBuilder.append(getString(2131303934));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(2131298052) + this.ktN.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131298013) + this.ktN.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(88375);
          return;
        }
        this.kre = paramIntent.getIntExtra("Ktag_range_index", 0);
        ab.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.kre) });
        if (this.kre >= 2)
        {
          this.krf = paramIntent.getStringExtra("Klabel_name_list");
          this.krg = paramIntent.getStringExtra("Kother_user_name_list");
          ab.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.kre), this.krf });
          if ((TextUtils.isEmpty(this.krf)) && (TextUtils.isEmpty(this.krg)))
          {
            ab.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(88375);
            return;
          }
          paramIntent = Arrays.asList(this.krf.split(","));
          this.kri = com.tencent.mm.plugin.card.d.l.bi(paramIntent);
          this.krh = com.tencent.mm.plugin.card.d.l.bh(paramIntent);
          if ((this.krg != null) && (this.krg.length() > 0))
          {
            paramIntent = Arrays.asList(this.krg.split(","));
            this.krh.addAll(paramIntent);
          }
          if (this.kri != null) {
            ab.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kri.size());
          }
          if (this.krh != null)
          {
            ab.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.krh.size());
            paramIntent = this.krh.iterator();
            while (paramIntent.hasNext()) {
              ab.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.kre == 2)
          {
            this.ktJ.Ir(this.kts.getString(2131298040, new Object[] { bcK() }));
            AppMethodBeat.o(88375);
            return;
          }
          if (this.kre == 3)
          {
            this.ktJ.Ir(this.kts.getString(2131298039, new Object[] { bcK() }));
            AppMethodBeat.o(88375);
            return;
          }
          this.ktJ.Ir(this.kts.getString(2131298038));
          AppMethodBeat.o(88375);
          return;
        }
        this.ktJ.Ir(this.kts.getString(2131298038));
        AppMethodBeat.o(88375);
        return;
        if (this.ktT != null) {
          this.ktT.bdu();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(88355);
    ab.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    e.c localc = new e.c((byte)0);
    localc.kug = e.b.kub;
    localc.kuh = paramc;
    localMessage.obj = localc;
    this.ktV.sendMessage(localMessage);
    AppMethodBeat.o(88355);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(88350);
    View localView = this.iCk.findViewById(paramInt);
    AppMethodBeat.o(88350);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(88352);
    String str = this.kts.getString(paramInt);
    AppMethodBeat.o(88352);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */