package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.protocal.protobuf.xo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.o;
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
  boolean dkt;
  private View hIZ;
  View.OnClickListener iAw;
  ListView mListView;
  com.tencent.mm.plugin.card.base.b nqp;
  MMActivity nqt;
  List<com.tencent.mm.plugin.card.model.b> nqu;
  ArrayList<rh> nqw;
  public ArrayList<String> nwA;
  public ArrayList<String> nwB;
  public int nwx;
  String nwy;
  String nwz;
  com.tencent.mm.plugin.card.ui.a.g nyI;
  i nyJ;
  boolean nyK;
  i nyL;
  i nyM;
  com.tencent.mm.plugin.card.widget.g nyN;
  LinearLayout nyO;
  com.tencent.mm.plugin.card.ui.view.g nyP;
  m nyQ;
  i nyR;
  i nyS;
  i nyT;
  i nyU;
  i nyV;
  i nyW;
  i nyX;
  i nyY;
  com.tencent.mm.plugin.card.ui.view.d nyZ;
  i nza;
  j nzb;
  boolean nzc;
  com.tencent.mm.plugin.card.b.f nzd;
  public String nze;
  public String nzf;
  HashMap<Integer, String> nzg;
  HashMap<String, String> nzh;
  ArrayList<String> nzi;
  d nzj;
  a nzk;
  private ap nzl;
  com.tencent.mm.sdk.b.c nzm;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.nyK = false;
    this.nzc = true;
    this.nqu = new ArrayList();
    this.nze = "";
    this.nzf = "";
    this.nwx = 0;
    this.nwy = "";
    this.nwz = "";
    this.nwA = new ArrayList();
    this.nwB = new ArrayList();
    this.nzg = new HashMap();
    this.nzh = new HashMap();
    this.nzi = new ArrayList();
    this.dkt = false;
    this.nzl = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.nzw == e.b.nzu)
          {
            if (e.this.nyP != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.this.nqt, paramAnonymousMessage.errMsg, false);
              e.this.nyP.bME();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.nzw == e.b.nzs)
          {
            if (e.this.nyP != null)
            {
              e.this.nyP.d(com.tencent.mm.plugin.card.d.c.nIY);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.this.nyP != null) {
            e.this.nyP.d(paramAnonymousMessage.nzx);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.iAw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        if ((paramAnonymousView.getId() == 2131297719) || (paramAnonymousView.getId() == 2131297710))
        {
          if (e.this.nqp.bHA())
          {
            if (e.this.nzj != null)
            {
              e.this.nzj.bKp();
              AppMethodBeat.o(113265);
            }
          }
          else if ((e.this.nqp.bHB()) && (e.this.nzj != null))
          {
            e.this.nzj.bKn();
            AppMethodBeat.o(113265);
          }
        }
        else
        {
          if ((paramAnonymousView.getId() == 2131300306) || (paramAnonymousView.getId() == 2131296317))
          {
            com.tencent.mm.plugin.card.d.b.ac(e.this.nqt, e.this.nzk.nys);
            AppMethodBeat.o(113265);
            return;
          }
          Object localObject;
          if ((paramAnonymousView.getId() == 2131298400) || (paramAnonymousView.getId() == 2131298384))
          {
            if (paramAnonymousView.getId() == 2131298400)
            {
              e.this.nzc = false;
              if ((e.this.nyP instanceof q))
              {
                localObject = ((q)e.this.nyP).e(com.tencent.mm.plugin.card.d.c.nJa);
                e.this.nzb.nDf = ((String)localObject);
              }
              localObject = e.this.nzb;
              bool = e.this.nzc;
              ((j)localObject).bLl();
              ((j)localObject).nzc = bool;
              if ((((j)localObject).iAs != null) && (!((j)localObject).iAs.isShowing()))
              {
                ((j)localObject).iAs.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).iAs.setFocusable(true);
                ((j)localObject).iAs.setTouchable(true);
                ((j)localObject).iAs.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).iAs.setOutsideTouchable(true);
                if (!((j)localObject).nzc) {
                  break label741;
                }
                ((j)localObject).nDb.setOnClickListener(((j)localObject).iAw);
                paramAnonymousView = ((j)localObject).nCX;
                if (((j)localObject).nvK == null) {
                  break label653;
                }
                ((j)localObject).nCX = com.tencent.mm.plugin.card.d.l.S(((j)localObject).nvK);
                label391:
                ((j)localObject).nDb.setImageBitmap(((j)localObject).nCX);
                ((j)localObject).nDe.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).iAu.setVisibility(8);
                ((j)localObject).nDa.setVisibility(0);
                paramAnonymousView = ((j)localObject).nqp.bHW().code;
                if ((((j)localObject).nqp.bHV().CSj != null) && (((j)localObject).nqp.bHV().CSj.DcV)) {
                  break label695;
                }
                if (bt.isNullOrNil(((j)localObject).nqp.bHW().CPH)) {
                  break label662;
                }
                paramAnonymousView = ((j)localObject).nqp.bHW().CPH;
                label520:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label715;
                }
                ((j)localObject).nDc.setText(com.tencent.mm.plugin.card.d.n.Rt(paramAnonymousView));
                if (!((j)localObject).nqp.bHK()) {
                  break label702;
                }
                ((j)localObject).nDc.setVisibility(0);
                label570:
                if (bt.isNullOrNil(((j)localObject).nqp.bHV().iau)) {
                  break label728;
                }
                ((j)localObject).nDd.setText(((j)localObject).nqp.bHV().iau);
                ((j)localObject).nDd.setVisibility(0);
              }
            }
            for (;;)
            {
              ((j)localObject).iAs.update();
              AppMethodBeat.o(113265);
              return;
              if (paramAnonymousView.getId() != 2131298384) {
                break;
              }
              e.this.nzc = true;
              break;
              label653:
              ((j)localObject).nCX = null;
              break label391;
              label662:
              if (!((j)localObject).nqp.bHP()) {
                break label520;
              }
              if (!bt.isNullOrNil(((j)localObject).nDf))
              {
                paramAnonymousView = ((j)localObject).nDf;
                break label520;
              }
              label695:
              paramAnonymousView = "";
              break label520;
              label702:
              ((j)localObject).nDc.setVisibility(8);
              break label570;
              label715:
              ((j)localObject).nDc.setVisibility(8);
              break label570;
              label728:
              ((j)localObject).nDd.setVisibility(8);
            }
            label741:
            ((j)localObject).iAt.setOnClickListener(((j)localObject).iAw);
            ((j)localObject).iAt.setImageBitmap(((j)localObject).iAr);
            paramAnonymousView = ((j)localObject).nqp.bHW().code;
            if ((((j)localObject).nqp.bHV().CSj == null) || (!((j)localObject).nqp.bHV().CSj.DcV)) {
              if (!bt.isNullOrNil(((j)localObject).nqp.bHW().CPH))
              {
                paramAnonymousView = ((j)localObject).nqp.bHW().CPH;
                label849:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label1023;
                }
                ((j)localObject).nCY.setText(com.tencent.mm.plugin.card.d.n.Rt(paramAnonymousView));
                if (!((j)localObject).nqp.bHK()) {
                  break label1010;
                }
                ((j)localObject).nCY.setVisibility(0);
                label899:
                if (TextUtils.isEmpty(((j)localObject).nqp.bHV().iau)) {
                  break label1036;
                }
                ((j)localObject).nCZ.setText(((j)localObject).nqp.bHV().iau);
                ((j)localObject).nCZ.setVisibility(0);
              }
            }
            for (;;)
            {
              ((j)localObject).iAu.setVisibility(0);
              ((j)localObject).nDa.setVisibility(8);
              break;
              if (!((j)localObject).nqp.bHP()) {
                break label849;
              }
              if (!bt.isNullOrNil(((j)localObject).nDf))
              {
                paramAnonymousView = ((j)localObject).nDf;
                break label849;
              }
              paramAnonymousView = "";
              break label849;
              label1010:
              ((j)localObject).nCY.setVisibility(8);
              break label899;
              label1023:
              ((j)localObject).nCY.setVisibility(8);
              break label899;
              label1036:
              ((j)localObject).nCZ.setVisibility(8);
            }
          }
          int j;
          String str1;
          int k;
          String str2;
          int i;
          if ((paramAnonymousView.getId() == 2131297769) || (paramAnonymousView.getId() == 2131297762) || (paramAnonymousView.getId() == 2131297761) || (paramAnonymousView.getId() == 2131298408) || (paramAnonymousView.getId() == 2131297760))
          {
            if (paramAnonymousView.getId() == 2131297769)
            {
              if (e.this.nqp.bHB())
              {
                paramAnonymousView = com.tencent.mm.plugin.report.service.h.vKh;
                j = e.this.nqp.bHV().lpz;
                localObject = e.this.nqp.bIa();
                str1 = e.this.nqp.bHZ();
                k = e.this.nzk.nvW;
                str2 = e.this.nzk.nys;
                if (e.this.nqp.bHT()) {}
                for (i = 1;; i = 0)
                {
                  paramAnonymousView.f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                  if (e.this.nzj == null) {
                    break;
                  }
                  e.this.nzj.iI(true);
                  AppMethodBeat.o(113265);
                  return;
                }
              }
              paramAnonymousView = new j.b();
              e.this.a(true, paramAnonymousView, false);
              AppMethodBeat.o(113265);
              return;
            }
            if ((paramAnonymousView.getId() == 2131298408) && (e.this.nqp.bHV().CSm))
            {
              AppMethodBeat.o(113265);
              return;
            }
            if (e.this.nqp.bHB())
            {
              if (e.this.nzj != null)
              {
                e.this.nzj.iI(false);
                AppMethodBeat.o(113265);
              }
            }
            else
            {
              paramAnonymousView = new j.b();
              e.this.a(false, paramAnonymousView, false);
              AppMethodBeat.o(113265);
            }
          }
          else if (paramAnonymousView.getId() == 2131296510)
          {
            if (!TextUtils.isEmpty(e.this.nqp.bHV().CRQ))
            {
              com.tencent.mm.plugin.card.d.b.a(e.this.nqt, e.this.nqp.bHV().CRQ, 3);
              com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(13), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", e.this.nqp.bHV().CRP });
              AppMethodBeat.o(113265);
            }
          }
          else
          {
            if (paramAnonymousView.getId() == 2131297878)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.nqp.bHV().lpz), e.this.nqp.bIa(), e.this.nqp.bHZ(), e.this.nzk.nys });
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("KLabel_range_index", e.this.nwx);
              paramAnonymousView.putExtra("Klabel_name_list", e.this.nwy);
              paramAnonymousView.putExtra("Kother_user_name_list", e.this.nwz);
              paramAnonymousView.putExtra("k_sns_label_ui_title", e.this.nqt.getString(2131756983));
              paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
              paramAnonymousView.putExtra("KLabel_is_filter_private", true);
              com.tencent.mm.bs.d.b(e.this.nqt, "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
              e.this.nqt.mmSetOnActivityResultCallback(e.this);
              AppMethodBeat.o(113265);
              return;
            }
            if (paramAnonymousView.getId() == 2131297891)
            {
              if (e.this.nqp.bHW().CPv != null)
              {
                localObject = e.this.nqp.bHW().CPv;
                i = ((Integer)paramAnonymousView.getTag()).intValue();
                paramAnonymousView = (xo)((LinkedList)localObject).get(i);
                if (com.tencent.mm.plugin.card.d.b.a(e.this.nqp.bHZ(), paramAnonymousView, e.this.nzk.nvW, e.this.nzk.nzq))
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(19), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                  AppMethodBeat.o(113265);
                  return;
                }
                if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, paramAnonymousView.url, 1);
                  localObject = com.tencent.mm.plugin.report.service.h.vKh;
                  switch (i)
                  {
                  default: 
                    i = 10;
                  }
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).f(11941, new Object[] { Integer.valueOf(i), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                  if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nqp.bHZ()))
                  {
                    com.tencent.mm.plugin.card.d.l.Rr(e.this.nqp.bHZ());
                    com.tencent.mm.plugin.card.d.b.b(e.this.nqt, e.this.nqp.bHV().nsK);
                  }
                  AppMethodBeat.o(113265);
                  return;
                  i = 10;
                  continue;
                  i = 11;
                  continue;
                  i = 12;
                  continue;
                  i = 16;
                }
              }
            }
            else if (paramAnonymousView.getId() == 2131297892)
            {
              if (e.this.nqp.bHW().CPv != null)
              {
                paramAnonymousView = (xo)e.this.nqp.bHW().CPv.get(0);
                if (com.tencent.mm.plugin.card.d.b.a(e.this.nqp.bHZ(), paramAnonymousView, e.this.nzk.nvW, e.this.nzk.nzq))
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(19), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                  AppMethodBeat.o(113265);
                  return;
                }
                if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, paramAnonymousView.url, 1);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(10), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                  if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nqp.bHZ()))
                  {
                    com.tencent.mm.plugin.card.d.l.Rr(e.this.nqp.bHZ());
                    com.tencent.mm.plugin.card.d.b.b(e.this.nqt, e.this.nqp.bHV().nsK);
                  }
                }
                AppMethodBeat.o(113265);
              }
            }
            else if ((paramAnonymousView.getId() == 2131297922) || (paramAnonymousView.getId() == 2131297869))
            {
              if (e.this.nqp.bHW().CPC != null) {
                if (e.this.nqp.bHN())
                {
                  if (e.this.nqp.bHB())
                  {
                    if (e.this.nzj != null)
                    {
                      e.this.nzj.iI(false);
                      AppMethodBeat.o(113265);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                    AppMethodBeat.o(113265);
                  }
                }
                else
                {
                  if (e.this.nqp.bHO())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.this.nqt, paramAnonymousView.nrh, paramAnonymousView.nri, false, e.this.nqp);
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this.nqp.bHW().CPC;
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.nqp.bHZ(), paramAnonymousView, e.this.nzk.nvW, e.this.nzk.nzq))
                  {
                    com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(20), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    localObject = com.tencent.mm.plugin.card.d.l.R(paramAnonymousView.url, paramAnonymousView.CSH);
                    com.tencent.mm.plugin.card.d.b.a(e.this.nqt, (String)localObject, 1);
                    com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(9), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.nqp.bHZ()))
                    {
                      com.tencent.mm.plugin.card.d.l.Rr(e.this.nqp.bHZ());
                      com.tencent.mm.plugin.card.d.b.b(e.this.nqt, e.this.nqp.bHV().nsK);
                    }
                  }
                  AppMethodBeat.o(113265);
                }
              }
            }
            else
            {
              String str3;
              if ((paramAnonymousView.getId() == 2131297784) || (paramAnonymousView.getId() == 2131297727))
              {
                paramAnonymousView = e.this.nqp.bHV().CRW;
                localObject = com.tencent.mm.plugin.report.service.h.vKh;
                j = e.this.nqp.bHV().lpz;
                str1 = e.this.nqp.bIa();
                str2 = e.this.nqp.bHZ();
                k = e.this.nzk.nvW;
                str3 = e.this.nzk.nys;
                if (e.this.nqp.bHT()) {}
                for (i = 1;; i = 0)
                {
                  ((com.tencent.mm.plugin.report.service.h)localObject).f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                  if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                    break;
                  }
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, paramAnonymousView.url, 1);
                  AppMethodBeat.o(113265);
                  return;
                }
                localObject = new Intent();
                if ((e.this.nqp instanceof CardInfo)) {
                  ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.this.nqp);
                }
                for (;;)
                {
                  ((Intent)localObject).setClass(e.this.nqt, CardDetailPreference.class);
                  paramAnonymousView = e.this.nqt;
                  localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  AppMethodBeat.o(113265);
                  return;
                  if ((e.this.nqp instanceof ShareCardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.this.nqp);
                  }
                }
              }
              if (paramAnonymousView.getId() == 2131304762)
              {
                if (com.tencent.mm.plugin.card.sharecard.a.b.QB(e.this.nqp.bIa()) <= 1)
                {
                  AppMethodBeat.o(113265);
                  return;
                }
                paramAnonymousView = e.this;
                if (!e.this.nyK) {}
                for (;;)
                {
                  paramAnonymousView.nyK = bool;
                  e.this.bJG();
                  AppMethodBeat.o(113265);
                  return;
                  bool = false;
                }
              }
              if (paramAnonymousView.getId() == 2131297731)
              {
                if ((e.this.nqp.bHV().CRS != null) && (!TextUtils.isEmpty(e.this.nqp.bHV().CRS.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, e.this.nqp.bHV().CRS.url, 3);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(3), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", e.this.nqp.bHV().CRS.text });
                  AppMethodBeat.o(113265);
                }
              }
              else if (paramAnonymousView.getId() == 2131297717)
              {
                if ((e.this.nqp.bHV().CRZ != null) && (!bt.isNullOrNil(e.this.nqp.bHV().CRZ.url)))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, e.this.nqp.bHV().CRZ.url, 1);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(14), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", e.this.nqp.bHV().CRZ.text });
                  AppMethodBeat.o(113265);
                }
              }
              else if ((paramAnonymousView.getId() == 2131304769) || (paramAnonymousView.getId() == 2131304770))
              {
                if (e.this.nqp.bHV().CRJ > 0)
                {
                  if ((e.this.nqw == null) || (e.this.nqw.size() == 0))
                  {
                    ad.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = (rh)e.this.nqw.get(0);
                  com.tencent.mm.plugin.card.d.b.a(e.this.nqt, paramAnonymousView.dpb, paramAnonymousView.dqQ, paramAnonymousView.hdQ);
                  localObject = com.tencent.mm.plugin.report.service.h.vKh;
                  j = e.this.nqp.bHV().lpz;
                  str1 = e.this.nqp.bIa();
                  str2 = e.this.nqp.bHZ();
                  k = e.this.nzk.nvW;
                  str3 = e.this.nzk.nys;
                  if (e.this.nqp.bHT()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject).f(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(5), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", paramAnonymousView.name });
                    AppMethodBeat.o(113265);
                    return;
                  }
                }
              }
              else
              {
                if (paramAnonymousView.getId() == 2131305807)
                {
                  if ((e.this.nqw == null) || (e.this.nqw.size() == 0))
                  {
                    ad.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (rh)e.this.nqw.get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.this.nqt.getString(2131756806))))
                  {
                    e.a(e.this);
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((rh)localObject).ntj))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.nqt, ((rh)localObject).ntj, 1);
                    com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(4), e.this.nqp.bHZ(), e.this.nqp.bIa(), "", ((rh)localObject).name });
                  }
                  AppMethodBeat.o(113265);
                  return;
                }
                if (paramAnonymousView.getId() == 2131305802) {
                  e.a(e.this);
                }
              }
            }
          }
        }
        AppMethodBeat.o(113265);
      }
    };
    this.nzm = new com.tencent.mm.sdk.b.c() {};
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void G(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.nyN != null) {
      this.nyN.G(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void QP(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.nqp instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.nqp);
    }
    for (;;)
    {
      localIntent.setClass(this.nqt, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.nzk.fsv);
      localIntent.putExtra("key_previous_scene", this.nzk.nvW);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.nzk.nzq);
      this.nqt.startActivityForResult(localIntent, 3);
      this.nqt.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.nqp instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.nqp);
      }
    }
  }
  
  private String bJI()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.nwy)) && (!TextUtils.isEmpty(this.nwz)))
    {
      str = this.nwy + "," + com.tencent.mm.plugin.card.d.l.Rp(this.nwz);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwy))
    {
      str = this.nwy;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.nwz))
    {
      str = com.tencent.mm.plugin.card.d.l.Rp(this.nwz);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void bKD()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.nyI == null)
    {
      i = 0;
      if (i != 0)
      {
        this.nyI.release();
        this.nyI = null;
        ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.nqp.bHV().lpz) });
      }
      if (this.nyI == null)
      {
        ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.nqp.bHV().lpz) });
        ad.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.nqp.bHV().lpz) });
        if (!this.nqp.bHB()) {
          break label423;
        }
        this.nyI = new com.tencent.mm.plugin.card.ui.a.h(this.nqt);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.nqp.bHV().lpz) });
      this.nyI.a(this.nqp, this.nzk);
      AppMethodBeat.o(113279);
      return;
      if (this.nqp.bHB())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nqp.bHC())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nqp.bHF())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nqp.bHD())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nqp.bHE())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.nqp.bHG())
      {
        if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.nyI instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.nqp.bHV().lpz)
      {
      default: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.a(this.nqt);
        break;
      case 0: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.c(this.nqt);
        break;
      case 10: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.e(this.nqt);
        break;
      case 11: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.b(this.nqt);
        break;
      case 20: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.f(this.nqt);
        break;
      case 30: 
        this.nyI = new com.tencent.mm.plugin.card.ui.a.d(this.nqt);
      }
    }
  }
  
  private void bKE()
  {
    AppMethodBeat.i(113285);
    if ((this.nqp.bHV().CSj != null) && (this.nqp.bHV().CSj.DcV))
    {
      this.nyP = new com.tencent.mm.plugin.card.ui.view.m();
      am.bJl().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.nqp.bHV().lpz == 10)
    {
      this.nyP = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.nyP = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void bKF()
  {
    AppMethodBeat.i(113286);
    if (this.dkt)
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.nqp.bHA()) && (this.nqp.bHC()))
    {
      this.hIZ.findViewById(2131297787).setBackgroundColor(this.nqt.getResources().getColor(2131101179));
      this.nqt.setActionbarColor(this.nqt.getResources().getColor(2131101179));
      localObject2 = this.hIZ.findViewById(2131299042);
      localObject1 = this.hIZ.findViewById(2131300735);
      localView = this.hIZ.findViewById(2131299039);
      if ((!this.nqp.bHA()) || (!this.nyI.bLK())) {
        break label1267;
      }
      if (!this.nqp.bHD()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(2131231515);
      this.hIZ.findViewById(2131300307).setBackgroundResource(2131231456);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.nqp.bHG())
      {
        localObject3 = (TextView)this.hIZ.findViewById(2131297477);
        localObject4 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.f.Wf(2131231510));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.nqp.bHB()) && (this.nyI.bLI()) && (this.nyK))
      {
        localObject4 = this.hIZ.findViewById(2131304758);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.nqp.bHA()) && (this.nyI.bLK()))
      {
        localObject4 = this.hIZ.findViewById(2131300307);
        ((Rect)localObject3).left = this.nqt.getResources().getDimensionPixelOffset(2131165480);
        ((Rect)localObject3).right = this.nqt.getResources().getDimensionPixelOffset(2131165480);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.nqp.bHE())
        {
          localObject3 = this.hIZ.findViewById(2131300308);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.nqt.getResources().getDimensionPixelSize(2131165568);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.nyI.bLK()) && (!this.nyI.bLI())) {
        break label1491;
      }
      if ((this.nyN != null) && (((this.nqp.bHA()) && (this.nqp.bHD())) || (this.nqp.bHB()))) {
        this.nyN.zq(0);
      }
      label650:
      if ((this.nyN != null) && (this.nqp.bHA()) && (this.nqp.bHC()))
      {
        i = this.nqt.getResources().getDimensionPixelOffset(2131165983);
        localObject3 = com.tencent.mm.plugin.card.d.l.eN(com.tencent.mm.plugin.card.d.l.Rm(this.nqp.bHV().gHT), i);
        this.nyN.a((ShapeDrawable)localObject3);
      }
      if ((this.nqp.bHA()) && (this.nqp.bHC()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.nqp.bHV().CRP)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.nqt.getResources().getDimensionPixelSize(2131165500);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.nqp.bHC()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.nqt.getResources().getDimensionPixelSize(2131165489);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.nqt.getResources().getDimensionPixelSize(2131165490);
        i = this.nqt.getResources().getDimensionPixelSize(2131165483);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.nqp.bHC()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.nqt.getResources().getDimensionPixelSize(2131165483);
        }
        if (TextUtils.isEmpty(this.nqp.bHV().CRP)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.nqp.bHV().CRP))
      {
        localView = findViewById(2131296509);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.hIZ.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.Rm(this.nqp.bHV().gHT);
      this.hIZ.findViewById(2131297787).setBackgroundColor(i);
      this.nqt.setActionbarColor(i);
      break;
      label1133:
      if (this.nqp.bHC())
      {
        this.hIZ.findViewById(2131300307).setBackgroundResource(0);
        localView.setBackgroundColor(this.nqt.getResources().getColor(2131101179));
        break label197;
      }
      if (this.nqp.bHE())
      {
        ((View)localObject2).setBackgroundResource(2131231515);
        this.hIZ.findViewById(2131300307).setBackgroundResource(2131231456);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.nqp.bHF()) || (!this.nqp.bHG())) {
        break label197;
      }
      localView.setBackgroundColor(this.nqt.getResources().getColor(2131101179));
      break label197;
      label1267:
      if (this.nqp.bHB())
      {
        if ((this.nyI.bLI()) && (this.nyK))
        {
          ((View)localObject2).setBackgroundResource(2131231515);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.nyI.bLI()) && (!this.nyK))
        {
          ((View)localObject2).setBackgroundResource(2131231511);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.nyI.bKR())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.nqp.bHD())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.nyI.bKR())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.nqp.bHE())
      {
        ((View)localObject2).setBackgroundResource(2131231519);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.nqt.getResources().getColor(2131101179));
      break label197;
      label1491:
      if ((this.nyN == null) || (((!this.nqp.bHA()) || (!this.nqp.bHD())) && (!this.nqp.bHB()))) {
        break label650;
      }
      if (this.nyI.bKR())
      {
        this.nyN.zq(2131231516);
        break label650;
      }
      this.nyN.zq(2131231514);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.nqt.getResources().getDimensionPixelSize(2131165198);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void bKG()
  {
    AppMethodBeat.i(113290);
    if (!this.nyI.bLM())
    {
      ad.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.nqu.clear();
    this.nqu.addAll(this.nzd.bIw());
    this.nyQ.setData(this.nqu);
    this.nyQ.nDK = this.nqp.bHG();
    this.nyQ.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void bKH()
  {
    AppMethodBeat.i(113291);
    if (this.nqp == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (bKI()) {
      bKK();
    }
    if (this.nyN == null) {
      bKJ();
    }
    if (this.nyN != null)
    {
      if (this.nqp.bHE()) {
        ((com.tencent.mm.plugin.card.widget.f)this.nyN).nqw = this.nqw;
      }
      this.nyN.d(this.nqp);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean bKI()
  {
    AppMethodBeat.i(113292);
    if (this.nyN == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.nqp.bHC())
    {
      if ((this.nyN instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nqp.bHF())
    {
      if ((this.nyN instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nqp.bHD())
    {
      if ((this.nyN instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nqp.bHE())
    {
      if ((this.nyN instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.nqp.bHG())
    {
      if ((this.nyN instanceof com.tencent.mm.plugin.card.widget.d))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    AppMethodBeat.o(113292);
    return false;
  }
  
  private void bKJ()
  {
    AppMethodBeat.i(113293);
    if (this.nqp.bHC()) {
      this.nyN = new com.tencent.mm.plugin.card.widget.e(this.nqt);
    }
    for (;;)
    {
      this.nyN.i(this.nqp);
      View localView = this.nyN.iS();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.nyO);
      }
      this.nyO.invalidate();
      this.nyN.setOnClickListener(this.iAw);
      G(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.nqp.bHF()) {
        this.nyN = new com.tencent.mm.plugin.card.widget.c(this.nqt);
      } else if (this.nqp.bHD()) {
        this.nyN = new com.tencent.mm.plugin.card.widget.b(this.nqt);
      } else if (this.nqp.bHE()) {
        this.nyN = new com.tencent.mm.plugin.card.widget.f(this.nqt);
      } else if (this.nqp.bHG()) {
        this.nyN = new com.tencent.mm.plugin.card.widget.d(this.nqt);
      } else {
        this.nyN = new com.tencent.mm.plugin.card.widget.b(this.nqt);
      }
    }
  }
  
  private void bKK()
  {
    AppMethodBeat.i(113294);
    View localView = this.nyN.iS();
    if (localView != null) {
      this.nyO.removeView(localView);
    }
    this.nyO.removeAllViews();
    this.nyO.invalidate();
    this.nyN.release();
    this.nyN = null;
    AppMethodBeat.o(113294);
  }
  
  private void bKL()
  {
    AppMethodBeat.i(113295);
    if ((this.nyN != null) && ((this.nyN instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.nyN).bKL();
    }
    AppMethodBeat.o(113295);
  }
  
  private void bKM()
  {
    AppMethodBeat.i(113296);
    qo localqo = this.nqp.bHW();
    this.nqp.a(localqo);
    com.tencent.mm.plugin.card.d.l.h(this.nqp);
    AppMethodBeat.o(113296);
  }
  
  private void bKN()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.nzg.clear();
    this.nzi.clear();
    if (this.nqp.bHJ())
    {
      this.nzi.add(getString(2131757029));
      this.nzg.put(Integer.valueOf(0), "menu_func_share_friend");
      this.nzi.add(getString(2131757028));
      this.nzg.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.nqp.bHW().CPy))
    {
      this.nzi.add(getString(2131756938));
      this.nzg.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    zc(j);
    if (this.nzi.size() > 0) {
      this.nqt.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void bKO()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.nzg.clear();
    this.nzi.clear();
    int i = j;
    if (this.nqp.bHA())
    {
      i = j;
      if (this.nqp.bHI())
      {
        if (bt.isNullOrNil(this.nqp.bHV().CSq)) {
          break label235;
        }
        this.nzi.add(this.nqp.bHV().CSq);
        this.nzg.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.nqp.bHW().CPy))
    {
      this.nzi.add(getString(2131756938));
      this.nzg.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.nqp.bHA())
    {
      this.nzi.add(getString(2131755707));
      this.nzg.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      zc(i);
      if (this.nzi.size() > 0) {
        this.nqt.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.nqp.bHG())
      {
        this.nzi.add(getString(2131756937));
        break;
      }
      this.nzi.add(getString(2131756936));
      break;
      i = j;
      if (this.nqp.bHB())
      {
        String str1 = com.tencent.mm.model.u.aqG();
        String str2 = this.nqp.bIb();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.nzi.add(getString(2131755707));
          this.nzg.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          ad.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void bKP()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.nzg.clear();
    this.nzi.clear();
    if (!TextUtils.isEmpty(this.nqp.bHW().CPy))
    {
      this.nzi.add(getString(2131756938));
      this.nzg.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    zc(i);
    if (this.nzi.size() > 0) {
      this.nqt.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.nyI.bLH())
    {
      this.nqt.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.nqt.setMMTitle(this.nzd.getTitle());
    AppMethodBeat.o(113289);
  }
  
  private void zc(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.nqp.bHW().CPA;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.nzh.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      ba localba = (ba)localLinkedList.get(paramInt);
      j = i;
      if (!bt.isNullOrNil(localba.text))
      {
        j = i;
        if (!bt.isNullOrNil(localba.url))
        {
          this.nzi.add(localba.text);
          this.nzg.put(Integer.valueOf(i), localba.text);
          this.nzh.put(localba.text, localba.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<rh> paramArrayList)
  {
    this.nqp = paramb;
    this.nzk = parama;
    this.nqw = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.nqp.bHW().CPC;
      if (this.nqp.bHO())
      {
        com.tencent.mm.plugin.card.d.b.a(this.nqt, paramb.nrh, paramb.nri, paramBoolean2, this.nqp);
        com.tencent.mm.plugin.report.service.h.vKh.f(11941, new Object[] { Integer.valueOf(17), this.nqp.bHZ(), this.nqp.bIa(), "", this.nqp.bHW().CPC.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((xo)localObject1).CRq)) && (!TextUtils.isEmpty(((xo)localObject1).CRr)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.nqp.bHZ(), (xo)localObject1, this.nzk.nvW, this.nzk.nzq);
        localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
        str1 = this.nqp.bHZ();
        str2 = this.nqp.bIa();
        if (((xo)localObject1).title != null) {}
        for (paramb = ((xo)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((xo)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.R(((xo)localObject1).url, ((xo)localObject1).CSH);
        com.tencent.mm.plugin.card.d.b.a(this.nqt, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.vKh;
        str1 = this.nqp.bHZ();
        str2 = this.nqp.bIa();
        if (((xo)localObject1).title != null) {}
        for (paramb = ((xo)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
      j = this.nqp.bHV().lpz;
      localObject2 = this.nqp.bIa();
      str1 = this.nqp.bHZ();
      k = this.nzk.nvW;
      str2 = this.nzk.nys;
      if (this.nqp.bHT()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        QP(paramb.nre);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
    int k = this.nqp.bHV().lpz;
    Object localObject2 = this.nqp.bIa();
    String str1 = this.nqp.bHZ();
    int m = this.nzk.nvW;
    String str2 = this.nzk.nys;
    if (this.nqp.bHT()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      QP(paramb.nre);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aD(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    ad.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.nzw = e.b.nzu;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131756842);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.nzl.sendMessage(localMessage);
      AppMethodBeat.o(113282);
      return;
      if (paramInt == 2) {
        paramString = getString(2131756811);
      } else {
        paramString = getString(2131756841);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113277);
    if (paramb != null)
    {
      this.nqp = paramb;
      if (this.nzj != null) {
        this.nzj.b(paramb);
      }
      bJG();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    ad.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.nzw = e.b.nzt;
    localc.nzx = paramc;
    localMessage.obj = localc;
    this.nzl.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void bIA()
  {
    AppMethodBeat.i(113283);
    ad.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.nzw = e.b.nzs;
    localMessage.obj = localc;
    this.nzl.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void bJG()
  {
    AppMethodBeat.i(113280);
    if (this.nqp == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.nzj != null) {
        this.nzj.bKq();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.nqp.bHV() == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.nzj != null) {
        this.nzj.bKq();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.nqp.bHW() == null)
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.nzj != null) {
        this.nzj.bKq();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.nqp.bHH())
    {
      ad.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.nqp.bHV().lpz) });
      if (!TextUtils.isEmpty(this.nqp.bHV().CRK))
      {
        com.tencent.mm.plugin.card.d.b.a(this.nqt, this.nqp.bHV().CRK, 0);
        if (this.nzj != null)
        {
          this.nzj.bKq();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.nqt, getString(2131756947), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.this.nzj != null) {
              e.this.nzj.bKq();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    ad.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    ad.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.nqp.bHV().CSf);
    this.nzd.a(this.nqp, this.nqw, this.nzk.fsv);
    bKD();
    this.nyI.bLZ();
    ad.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    bKH();
    if (this.nyI.bLI())
    {
      ad.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.nyJ.update();
      if (!this.nyI.bLz()) {
        break label1156;
      }
      if (this.nza == null)
      {
        this.nza = new com.tencent.mm.plugin.card.ui.view.b();
        this.nza.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.nza.update();
      label436:
      this.nqt.showOptionMenu(this.nyI.bLD());
      if (this.nyI.bLE()) {
        bKN();
      }
      if (this.nyI.bLF()) {
        bKO();
      }
      if (this.nyI.bLG()) {
        bKP();
      }
      bKL();
      G(this.nyI.bLB(), this.nyI.bLC());
      if ((this.nqp.bHC()) || (!this.nyI.bLK())) {
        break label1181;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.nyL.update();
      label565:
      if (this.nyN != null) {
        this.nyN.iO(this.nyI.bKR());
      }
      bKF();
      if (!this.nyI.bLP()) {
        break label1278;
      }
      if (this.nyS == null)
      {
        this.nyS = new com.tencent.mm.plugin.card.ui.view.y();
        this.nyS.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.nyS.update();
      label647:
      if (!this.nyI.bLY()) {
        break label1303;
      }
      if (this.nyR == null)
      {
        this.nyR = new com.tencent.mm.plugin.card.ui.view.c();
        this.nyR.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.nyR.update();
      label700:
      if (!this.nyI.bLQ()) {
        break label1328;
      }
      if (this.nyT == null)
      {
        this.nyT = new k();
        this.nyT.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.nyT.update();
      label753:
      if (!this.nyI.bLR()) {
        break label1353;
      }
      if (this.nyU == null)
      {
        this.nyU = new w();
        this.nyU.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.nyU.update();
      label806:
      if (!this.nyI.bLS()) {
        break label1378;
      }
      if (this.nyV == null)
      {
        this.nyV = new com.tencent.mm.plugin.card.ui.view.l();
        this.nyV.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.nyV.update();
      label859:
      if (!this.nyI.bLT()) {
        break label1403;
      }
      if (this.nyW == null)
      {
        this.nyW = new z();
        this.nyW.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.nyW.update();
      label912:
      if (!this.nyI.bLV()) {
        break label1428;
      }
      if (this.nyX == null)
      {
        this.nyX = new com.tencent.mm.plugin.card.ui.view.e();
        this.nyX.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.nyX.update();
      label965:
      if (!this.nyI.bLU()) {
        break label1453;
      }
      if (this.nyY == null)
      {
        this.nyY = new com.tencent.mm.plugin.card.ui.view.u();
        this.nyY.a(this);
      }
      ad.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.nyY.update();
      label1018:
      bKG();
      if (!this.nyI.bLN()) {
        break label1530;
      }
      bKM();
      if (!this.nyI.bLO()) {
        break label1513;
      }
      if (this.nyP != null) {
        break label1478;
      }
      bKE();
      this.nyP.a(this);
      this.nyP.update();
      label1076:
      if (this.nyN != null) {
        this.nyN.iN(true);
      }
      label1093:
      if (!this.nyI.bLW()) {
        break label1572;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.nyZ.update();
    }
    for (;;)
    {
      this.nzb.nqp = this.nqp;
      AppMethodBeat.o(113280);
      return;
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.nyJ.bMB();
      break;
      label1156:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.nza == null) {
        break label436;
      }
      this.nza.bMB();
      break label436;
      label1181:
      if ((this.nqp.bHC()) && (this.nyI.bLK()))
      {
        ad.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.nyM.update();
        break label565;
      }
      if (this.nyI.bLL())
      {
        ad.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.nyM.update();
        break label565;
      }
      ad.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.nyM.bMB();
      this.nyL.bMB();
      break label565;
      label1278:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.nyS == null) {
        break label647;
      }
      this.nyS.bMB();
      break label647;
      label1303:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.nyR == null) {
        break label700;
      }
      this.nyR.bMB();
      break label700;
      label1328:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.nyT == null) {
        break label753;
      }
      this.nyT.bMB();
      break label753;
      label1353:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.nyU == null) {
        break label806;
      }
      this.nyU.bMB();
      break label806;
      label1378:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.nyV == null) {
        break label859;
      }
      this.nyV.bMB();
      break label859;
      label1403:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.nyW == null) {
        break label912;
      }
      this.nyW.bMB();
      break label912;
      label1428:
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.nyX == null) {
        break label965;
      }
      this.nyX.bMB();
      break label965;
      label1453:
      ad.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.nyY == null) {
        break label1018;
      }
      this.nyY.bMB();
      break label1018;
      label1478:
      if (!this.nyP.f(this.nqp)) {
        break label1076;
      }
      this.nyP.b(this.nqp);
      this.nyP.update();
      break label1076;
      label1513:
      if (this.nyP == null) {
        break label1076;
      }
      this.nyP.bMG();
      break label1076;
      label1530:
      ad.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.nyP != null) {
        this.nyP.bMG();
      }
      if (this.nyN == null) {
        break label1093;
      }
      this.nyN.iN(false);
      break label1093;
      label1572:
      ad.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.nyZ.bMB();
    }
  }
  
  public final a bKA()
  {
    return this.nzk;
  }
  
  public final com.tencent.mm.plugin.card.b.f bKB()
  {
    return this.nzd;
  }
  
  public final j bKC()
  {
    return this.nzb;
  }
  
  public final int bKQ()
  {
    AppMethodBeat.i(113304);
    if (this.nzd == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.nzd.bIy())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean bKR()
  {
    AppMethodBeat.i(113305);
    if (this.nyI == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.nyI.bKR();
    AppMethodBeat.o(113305);
    return bool;
  }
  
  public final com.tencent.mm.plugin.card.base.b bKt()
  {
    return this.nqp;
  }
  
  public final boolean bKu()
  {
    return this.nyK;
  }
  
  public final void bKv()
  {
    this.nyK = false;
  }
  
  public final MMActivity bKw()
  {
    return this.nqt;
  }
  
  public final View.OnClickListener bKx()
  {
    return this.iAw;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g bKy()
  {
    return this.nyI;
  }
  
  public final d bKz()
  {
    return this.nzj;
  }
  
  public final void c(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(113301);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113301);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        this.nze = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.nze;
        if ((this.nqp == null) || (this.nqp.bHV() == null))
        {
          ad.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.nqp.bHX().Ekz)) && (!this.nqp.bHG())) {
            localStringBuilder.append(this.nqp.bHX().Ekz);
          }
        }
        for (;;)
        {
          String str = this.nqp.bHV().title + "\n" + this.nqp.bHV().nsK;
          ab.a.BZI.a(this.nqt.getController(), localStringBuilder.toString(), this.nqp.bHV().gGR, str, true, this.nqt.getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.nzf = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.this.nzj != null) {
                    e.this.nzj.QO(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.nqp.bHV().lpz), e.this.nqp.bIa(), e.this.nqp.bHZ(), e.this.nze });
                  com.tencent.mm.ui.base.h.cf(e.this.nqt, e.this.nqt.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  paramAnonymousString = e.this;
                  paramAnonymousString.nqp.bHX().Ekz = (paramAnonymousString.getString(2131756994) + paramAnonymousString.nzd.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.nqp, paramAnonymousString.nze, paramAnonymousString.nzk.nyu, 2);
                  com.tencent.mm.plugin.card.d.l.eJ(paramAnonymousString.nzf, paramAnonymousString.nze);
                  com.tencent.mm.ui.base.h.cf(e.this.nqt, e.this.nqt.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  paramAnonymousString = e.this;
                  if (TextUtils.isEmpty(paramAnonymousString.nqp.bIb())) {
                    paramAnonymousString.nqp.Qh(com.tencent.mm.model.u.aqG());
                  }
                  paramAnonymousString.nqp.bHX().Ekz = (paramAnonymousString.getString(2131756955) + paramAnonymousString.nzd.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.nqp, paramAnonymousString.nze, paramAnonymousString.nzk.nyu, 23);
                  com.tencent.mm.plugin.card.d.l.eJ(paramAnonymousString.nzf, paramAnonymousString.nze);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.this.nzk.fsv), Integer.valueOf(e.this.nqp.bHV().lpz), e.this.nqp.bIa(), e.this.nqp.bHZ(), e.this.nze });
                  com.tencent.mm.ui.base.h.cf(e.this.nqt, e.this.nqt.getResources().getString(2131756873));
                }
              }
              AppMethodBeat.o(113270);
            }
          });
          AppMethodBeat.o(113301);
          return;
          localStringBuilder.append(getString(2131763948));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(2131756994) + this.nzd.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131756955) + this.nzd.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.nwx = paramIntent.getIntExtra("Ktag_range_index", 0);
        ad.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.nwx) });
        if (this.nwx >= 2)
        {
          this.nwy = paramIntent.getStringExtra("Klabel_name_list");
          this.nwz = paramIntent.getStringExtra("Kother_user_name_list");
          ad.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.nwx), this.nwy });
          if ((TextUtils.isEmpty(this.nwy)) && (TextUtils.isEmpty(this.nwz)))
          {
            ad.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.nwy.split(","));
          this.nwB = com.tencent.mm.plugin.card.d.l.cE(paramIntent);
          this.nwA = com.tencent.mm.plugin.card.d.l.cD(paramIntent);
          if ((this.nwz != null) && (this.nwz.length() > 0))
          {
            paramIntent = Arrays.asList(this.nwz.split(","));
            this.nwA.addAll(paramIntent);
          }
          if (this.nwB != null) {
            ad.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.nwB.size());
          }
          if (this.nwA != null)
          {
            ad.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.nwA.size());
            paramIntent = this.nwA.iterator();
            while (paramIntent.hasNext()) {
              ad.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.nwx == 2)
          {
            this.nyZ.Rc(this.nqt.getString(2131756982, new Object[] { bJI() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.nwx == 3)
          {
            this.nyZ.Rc(this.nqt.getString(2131756981, new Object[] { bJI() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.nyZ.Rc(this.nqt.getString(2131756980));
          AppMethodBeat.o(113301);
          return;
        }
        this.nyZ.Rc(this.nqt.getString(2131756980));
        AppMethodBeat.o(113301);
        return;
        if (this.nzj != null) {
          this.nzj.bKs();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    ad.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.nzw = e.b.nzr;
    localc.nzx = paramc;
    localMessage.obj = localc;
    this.nzl.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.hIZ.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.nqt.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int fsv = 3;
    public String nqb = "";
    public boolean nrB = false;
    public int nvW = -1;
    public String nxZ = "";
    public String nya = "";
    public String nys = "";
    public String nyt = "";
    public String nyu = "";
    public int nzq = 0;
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b nzw;
    com.tencent.mm.plugin.card.d.c nzx;
  }
  
  public static abstract interface d
  {
    public abstract void QO(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void bKm();
    
    public abstract void bKn();
    
    public abstract void bKo();
    
    public abstract void bKp();
    
    public abstract void bKq();
    
    public abstract void bKr();
    
    public abstract void bKs();
    
    public abstract void iI(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */