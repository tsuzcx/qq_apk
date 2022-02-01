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
import com.tencent.mm.model.v;
import com.tencent.mm.model.z.b;
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
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.pluginsdk.ui.applet.ab;
import com.tencent.mm.pluginsdk.ui.applet.ab.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  boolean dus;
  private View iFK;
  View.OnClickListener jwB;
  ListView mListView;
  com.tencent.mm.plugin.card.base.b oDm;
  MMActivity oDq;
  List<com.tencent.mm.plugin.card.model.b> oDr;
  ArrayList<tn> oDt;
  public int oJt;
  String oJu;
  String oJv;
  public ArrayList<String> oJw;
  public ArrayList<String> oJx;
  com.tencent.mm.plugin.card.ui.a.g oLE;
  i oLF;
  boolean oLG;
  i oLH;
  i oLI;
  com.tencent.mm.plugin.card.widget.g oLJ;
  LinearLayout oLK;
  com.tencent.mm.plugin.card.ui.view.g oLL;
  m oLM;
  i oLN;
  i oLO;
  i oLP;
  i oLQ;
  i oLR;
  i oLS;
  i oLT;
  i oLU;
  com.tencent.mm.plugin.card.ui.view.d oLV;
  i oLW;
  j oLX;
  boolean oLY;
  com.tencent.mm.plugin.card.b.f oLZ;
  public String oMa;
  public String oMb;
  HashMap<Integer, String> oMc;
  HashMap<String, String> oMd;
  ArrayList<String> oMe;
  d oMf;
  a oMg;
  private aq oMh;
  com.tencent.mm.sdk.b.c oMi;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.oLG = false;
    this.oLY = true;
    this.oDr = new ArrayList();
    this.oMa = "";
    this.oMb = "";
    this.oJt = 0;
    this.oJu = "";
    this.oJv = "";
    this.oJw = new ArrayList();
    this.oJx = new ArrayList();
    this.oMc = new HashMap();
    this.oMd = new HashMap();
    this.oMe = new ArrayList();
    this.dus = false;
    this.oMh = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.oMs == e.b.oMq)
          {
            if (e.this.oLL != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.this.oDq, paramAnonymousMessage.errMsg, false);
              e.this.oLL.bZJ();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.oMs == e.b.oMo)
          {
            if (e.this.oLL != null)
            {
              e.this.oLL.d(com.tencent.mm.plugin.card.d.c.oVV);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.this.oLL != null) {
            e.this.oLL.d(paramAnonymousMessage.oMt);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.jwB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getId() == 2131297719) || (paramAnonymousView.getId() == 2131297710)) {
          if (e.this.oDm.bUH()) {
            if (e.this.oMf != null) {
              e.this.oMf.bXw();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113265);
          return;
          if ((e.this.oDm.bUI()) && (e.this.oMf != null))
          {
            e.this.oMf.bXu();
            continue;
            if ((paramAnonymousView.getId() == 2131300306) || (paramAnonymousView.getId() == 2131296317))
            {
              com.tencent.mm.plugin.card.d.b.ae(e.this.oDq, e.this.oMg.oLo);
            }
            else if ((paramAnonymousView.getId() == 2131298400) || (paramAnonymousView.getId() == 2131298384))
            {
              if (paramAnonymousView.getId() == 2131298400)
              {
                e.this.oLY = false;
                label229:
                if ((e.this.oLL instanceof q))
                {
                  localObject = ((q)e.this.oLL).e(com.tencent.mm.plugin.card.d.c.oVX);
                  e.this.oLX.oQb = ((String)localObject);
                }
                localObject = e.this.oLX;
                bool = e.this.oLY;
                ((j)localObject).bYs();
                ((j)localObject).oLY = bool;
                if ((((j)localObject).jwx == null) || (((j)localObject).jwx.isShowing())) {
                  continue;
                }
                ((j)localObject).jwx.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).jwx.setFocusable(true);
                ((j)localObject).jwx.setTouchable(true);
                ((j)localObject).jwx.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).jwx.setOutsideTouchable(true);
                if (!((j)localObject).oLY) {
                  break label776;
                }
                ((j)localObject).oPX.setOnClickListener(((j)localObject).jwB);
                paramAnonymousView = ((j)localObject).oPT;
                if (((j)localObject).oIG == null) {
                  break label688;
                }
                ((j)localObject).oPT = com.tencent.mm.plugin.card.d.l.T(((j)localObject).oIG);
                label429:
                ((j)localObject).oPX.setImageBitmap(((j)localObject).oPT);
                ((j)localObject).oQa.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).jwz.setVisibility(8);
                ((j)localObject).oPW.setVisibility(0);
                paramAnonymousView = ((j)localObject).oDm.bVd().code;
                if ((((j)localObject).oDm.bVc().GkC != null) && (((j)localObject).oDm.bVc().GkC.Gwf)) {
                  break label730;
                }
                if (bu.isNullOrNil(((j)localObject).oDm.bVd().Gib)) {
                  break label697;
                }
                paramAnonymousView = ((j)localObject).oDm.bVd().Gib;
                label558:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label750;
                }
                ((j)localObject).oPY.setText(com.tencent.mm.plugin.card.d.n.aaf(paramAnonymousView));
                if (!((j)localObject).oDm.bUR()) {
                  break label737;
                }
                ((j)localObject).oPY.setVisibility(0);
                label608:
                if (bu.isNullOrNil(((j)localObject).oDm.bVc().iWA)) {
                  break label763;
                }
                ((j)localObject).oPZ.setText(((j)localObject).oDm.bVc().iWA);
                ((j)localObject).oPZ.setVisibility(0);
              }
              for (;;)
              {
                ((j)localObject).jwx.update();
                break;
                if (paramAnonymousView.getId() != 2131298384) {
                  break label229;
                }
                e.this.oLY = true;
                break label229;
                label688:
                ((j)localObject).oPT = null;
                break label429;
                label697:
                if (!((j)localObject).oDm.bUW()) {
                  break label558;
                }
                if (!bu.isNullOrNil(((j)localObject).oQb))
                {
                  paramAnonymousView = ((j)localObject).oQb;
                  break label558;
                }
                label730:
                paramAnonymousView = "";
                break label558;
                label737:
                ((j)localObject).oPY.setVisibility(8);
                break label608;
                label750:
                ((j)localObject).oPY.setVisibility(8);
                break label608;
                label763:
                ((j)localObject).oPZ.setVisibility(8);
              }
              label776:
              ((j)localObject).jwy.setOnClickListener(((j)localObject).jwB);
              ((j)localObject).jwy.setImageBitmap(((j)localObject).jww);
              paramAnonymousView = ((j)localObject).oDm.bVd().code;
              if ((((j)localObject).oDm.bVc().GkC == null) || (!((j)localObject).oDm.bVc().GkC.Gwf)) {
                if (!bu.isNullOrNil(((j)localObject).oDm.bVd().Gib))
                {
                  paramAnonymousView = ((j)localObject).oDm.bVd().Gib;
                  label884:
                  if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                    break label1058;
                  }
                  ((j)localObject).oPU.setText(com.tencent.mm.plugin.card.d.n.aaf(paramAnonymousView));
                  if (!((j)localObject).oDm.bUR()) {
                    break label1045;
                  }
                  ((j)localObject).oPU.setVisibility(0);
                  label934:
                  if (TextUtils.isEmpty(((j)localObject).oDm.bVc().iWA)) {
                    break label1071;
                  }
                  ((j)localObject).oPV.setText(((j)localObject).oDm.bVc().iWA);
                  ((j)localObject).oPV.setVisibility(0);
                }
              }
              for (;;)
              {
                ((j)localObject).jwz.setVisibility(0);
                ((j)localObject).oPW.setVisibility(8);
                break;
                if (!((j)localObject).oDm.bUW()) {
                  break label884;
                }
                if (!bu.isNullOrNil(((j)localObject).oQb))
                {
                  paramAnonymousView = ((j)localObject).oQb;
                  break label884;
                }
                paramAnonymousView = "";
                break label884;
                label1045:
                ((j)localObject).oPU.setVisibility(8);
                break label934;
                label1058:
                ((j)localObject).oPU.setVisibility(8);
                break label934;
                label1071:
                ((j)localObject).oPV.setVisibility(8);
              }
            }
            else
            {
              int j;
              String str1;
              int k;
              String str2;
              int i;
              if ((paramAnonymousView.getId() == 2131297769) || (paramAnonymousView.getId() == 2131297762) || (paramAnonymousView.getId() == 2131297761) || (paramAnonymousView.getId() == 2131298408) || (paramAnonymousView.getId() == 2131297760))
              {
                if (paramAnonymousView.getId() == 2131297769)
                {
                  if (e.this.oDm.bUI())
                  {
                    paramAnonymousView = com.tencent.mm.plugin.report.service.g.yxI;
                    j = e.this.oDm.bVc().mwj;
                    localObject = e.this.oDm.bVh();
                    str1 = e.this.oDm.bVg();
                    k = e.this.oMg.oIS;
                    str2 = e.this.oMg.oLo;
                    if (e.this.oDm.bVa()) {}
                    for (i = 1;; i = 0)
                    {
                      paramAnonymousView.f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                      if (e.this.oMf == null) {
                        break;
                      }
                      e.this.oMf.jv(true);
                      break;
                    }
                  }
                  paramAnonymousView = new j.b();
                  e.this.a(true, paramAnonymousView, false);
                }
                else
                {
                  if ((paramAnonymousView.getId() == 2131298408) && (e.this.oDm.bVc().GkF))
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (e.this.oDm.bUI())
                  {
                    if (e.this.oMf != null) {
                      e.this.oMf.jv(false);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                  }
                }
              }
              else if (paramAnonymousView.getId() == 2131296510)
              {
                if (!TextUtils.isEmpty(e.this.oDm.bVc().Gkj))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.this.oDq, e.this.oDm.bVc().Gkj, 3);
                  com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(13), e.this.oDm.bVg(), e.this.oDm.bVh(), "", e.this.oDm.bVc().Gki });
                }
              }
              else if (paramAnonymousView.getId() == 2131297878)
              {
                com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.this.oDm.bVc().mwj), e.this.oDm.bVh(), e.this.oDm.bVg(), e.this.oMg.oLo });
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KLabel_range_index", e.this.oJt);
                paramAnonymousView.putExtra("Klabel_name_list", e.this.oJu);
                paramAnonymousView.putExtra("Kother_user_name_list", e.this.oJv);
                paramAnonymousView.putExtra("k_sns_label_ui_title", e.this.oDq.getString(2131756983));
                paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
                paramAnonymousView.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.br.d.b(e.this.oDq, "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
                e.this.oDq.mmSetOnActivityResultCallback(e.this);
              }
              else if (paramAnonymousView.getId() == 2131297891)
              {
                if (e.this.oDm.bVd().GhP != null)
                {
                  localObject = e.this.oDm.bVd().GhP;
                  i = ((Integer)paramAnonymousView.getTag()).intValue();
                  paramAnonymousView = (aai)((LinkedList)localObject).get(i);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.oDm.bVg(), paramAnonymousView, e.this.oMg.oIS, e.this.oMg.oMm))
                  {
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(19), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, paramAnonymousView.url, 1);
                    localObject = com.tencent.mm.plugin.report.service.g.yxI;
                    switch (i)
                    {
                    default: 
                      i = 10;
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(11941, new Object[] { Integer.valueOf(i), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                      if (!com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.oDm.bVg())) {
                        break;
                      }
                      com.tencent.mm.plugin.card.d.l.aad(e.this.oDm.bVg());
                      com.tencent.mm.plugin.card.d.b.b(e.this.oDq, e.this.oDm.bVc().oFG);
                      break;
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
              }
              else if (paramAnonymousView.getId() == 2131297892)
              {
                if (e.this.oDm.bVd().GhP != null)
                {
                  paramAnonymousView = (aai)e.this.oDm.bVd().GhP.get(0);
                  if (com.tencent.mm.plugin.card.d.b.a(e.this.oDm.bVg(), paramAnonymousView, e.this.oMg.oIS, e.this.oMg.oMm))
                  {
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(19), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(10), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.oDm.bVg()))
                    {
                      com.tencent.mm.plugin.card.d.l.aad(e.this.oDm.bVg());
                      com.tencent.mm.plugin.card.d.b.b(e.this.oDq, e.this.oDm.bVc().oFG);
                    }
                  }
                }
              }
              else if ((paramAnonymousView.getId() == 2131297922) || (paramAnonymousView.getId() == 2131297869))
              {
                if (e.this.oDm.bVd().GhW != null) {
                  if (e.this.oDm.bUU())
                  {
                    if (e.this.oDm.bUI())
                    {
                      if (e.this.oMf != null) {
                        e.this.oMf.jv(false);
                      }
                    }
                    else
                    {
                      paramAnonymousView = new j.b();
                      e.this.a(false, paramAnonymousView, false);
                    }
                  }
                  else if (e.this.oDm.bUV())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, paramAnonymousView.oEe, paramAnonymousView.oEf, false, e.this.oDm);
                  }
                  else
                  {
                    paramAnonymousView = e.this.oDm.bVd().GhW;
                    if (com.tencent.mm.plugin.card.d.b.a(e.this.oDm.bVg(), paramAnonymousView, e.this.oMg.oIS, e.this.oMg.oMm))
                    {
                      com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(20), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                    }
                    else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                    {
                      localObject = com.tencent.mm.plugin.card.d.l.Z(paramAnonymousView.url, paramAnonymousView.GkZ);
                      com.tencent.mm.plugin.card.d.b.a(e.this.oDq, (String)localObject, 1);
                      com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(9), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.title });
                      if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.this.oDm.bVg()))
                      {
                        com.tencent.mm.plugin.card.d.l.aad(e.this.oDm.bVg());
                        com.tencent.mm.plugin.card.d.b.b(e.this.oDq, e.this.oDm.bVc().oFG);
                      }
                    }
                  }
                }
              }
              else
              {
                String str3;
                if ((paramAnonymousView.getId() == 2131297784) || (paramAnonymousView.getId() == 2131297727))
                {
                  paramAnonymousView = e.this.oDm.bVc().Gkp;
                  localObject = com.tencent.mm.plugin.report.service.g.yxI;
                  j = e.this.oDm.bVc().mwj;
                  str1 = e.this.oDm.bVh();
                  str2 = e.this.oDm.bVg();
                  k = e.this.oMg.oIS;
                  str3 = e.this.oMg.oLo;
                  if (e.this.oDm.bVa()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.g)localObject).f(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                      break label3233;
                    }
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, paramAnonymousView.url, 1);
                    break;
                  }
                  label3233:
                  localObject = new Intent();
                  if ((e.this.oDm instanceof CardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.this.oDm);
                  }
                  for (;;)
                  {
                    ((Intent)localObject).setClass(e.this.oDq, CardDetailPreference.class);
                    paramAnonymousView = e.this.oDq;
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
                    com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                    if ((e.this.oDm instanceof ShareCardInfo)) {
                      ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.this.oDm);
                    }
                  }
                }
                if (paramAnonymousView.getId() == 2131304762)
                {
                  if (com.tencent.mm.plugin.card.sharecard.a.b.Zn(e.this.oDm.bVh()) <= 1)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this;
                  if (!e.this.oLG) {}
                  for (;;)
                  {
                    paramAnonymousView.oLG = bool;
                    e.this.bWN();
                    break;
                    bool = false;
                  }
                }
                if (paramAnonymousView.getId() == 2131297731)
                {
                  if ((e.this.oDm.bVc().Gkl != null) && (!TextUtils.isEmpty(e.this.oDm.bVc().Gkl.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, e.this.oDm.bVc().Gkl.url, 3);
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(3), e.this.oDm.bVg(), e.this.oDm.bVh(), "", e.this.oDm.bVc().Gkl.text });
                  }
                }
                else if (paramAnonymousView.getId() == 2131297717)
                {
                  if ((e.this.oDm.bVc().Gks != null) && (!bu.isNullOrNil(e.this.oDm.bVc().Gks.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, e.this.oDm.bVc().Gks.url, 1);
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(14), e.this.oDm.bVg(), e.this.oDm.bVh(), "", e.this.oDm.bVc().Gks.text });
                  }
                }
                else if ((paramAnonymousView.getId() == 2131304769) || (paramAnonymousView.getId() == 2131304770))
                {
                  if (e.this.oDm.bVc().Gkc > 0)
                  {
                    if ((e.this.oDt == null) || (e.this.oDt.size() == 0))
                    {
                      ae.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(113265);
                      return;
                    }
                    paramAnonymousView = (tn)e.this.oDt.get(0);
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, paramAnonymousView.dzE, paramAnonymousView.dBu, paramAnonymousView.hZQ);
                    localObject = com.tencent.mm.plugin.report.service.g.yxI;
                    j = e.this.oDm.bVc().mwj;
                    str1 = e.this.oDm.bVh();
                    str2 = e.this.oDm.bVg();
                    k = e.this.oMg.oIS;
                    str3 = e.this.oMg.oLo;
                    if (e.this.oDm.bVa()) {}
                    for (i = 1;; i = 0)
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).f(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                      com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(5), e.this.oDm.bVg(), e.this.oDm.bVh(), "", paramAnonymousView.name });
                      break;
                    }
                  }
                }
                else if (paramAnonymousView.getId() == 2131305807)
                {
                  if ((e.this.oDt == null) || (e.this.oDt.size() == 0))
                  {
                    ae.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (tn)e.this.oDt.get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.this.oDq.getString(2131756806))))
                  {
                    e.a(e.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((tn)localObject).oGf))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.this.oDq, ((tn)localObject).oGf, 1);
                    com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(4), e.this.oDm.bVg(), e.this.oDm.bVh(), "", ((tn)localObject).name });
                  }
                }
                else if (paramAnonymousView.getId() == 2131305802)
                {
                  e.a(e.this);
                }
              }
            }
          }
        }
      }
    };
    this.oMi = new e.7(this);
    this.oDq = paramMMActivity;
    this.iFK = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void AN(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.oDm.bVd().GhU;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.oMd.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      bc localbc = (bc)localLinkedList.get(paramInt);
      j = i;
      if (!bu.isNullOrNil(localbc.text))
      {
        j = i;
        if (!bu.isNullOrNil(localbc.url))
        {
          this.oMe.add(localbc.text);
          this.oMc.put(Integer.valueOf(i), localbc.text);
          this.oMd.put(localbc.text, localbc.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  private void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.oLJ != null) {
      this.oLJ.I(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void ZB(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.oDm instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.oDm);
    }
    for (;;)
    {
      localIntent.setClass(this.oDq, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.oMg.fRv);
      localIntent.putExtra("key_previous_scene", this.oMg.oIS);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.oMg.oMm);
      this.oDq.startActivityForResult(localIntent, 3);
      this.oDq.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.oDm instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.oDm);
      }
    }
  }
  
  private String bWP()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.oJu)) && (!TextUtils.isEmpty(this.oJv)))
    {
      str = this.oJu + "," + com.tencent.mm.plugin.card.d.l.aab(this.oJv);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJu))
    {
      str = this.oJu;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.oJv))
    {
      str = com.tencent.mm.plugin.card.d.l.aab(this.oJv);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void bXK()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.oLE == null)
    {
      i = 0;
      if (i != 0)
      {
        this.oLE.release();
        this.oLE = null;
        ae.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.oDm.bVc().mwj) });
      }
      if (this.oLE == null)
      {
        ae.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.oDm.bVc().mwj) });
        ae.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.oDm.bVc().mwj) });
        if (!this.oDm.bUI()) {
          break label423;
        }
        this.oLE = new com.tencent.mm.plugin.card.ui.a.h(this.oDq);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.oDm.bVc().mwj) });
      this.oLE.a(this.oDm, this.oMg);
      AppMethodBeat.o(113279);
      return;
      if (this.oDm.bUI())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.oDm.bUJ())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.oDm.bUM())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.oDm.bUK())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.oDm.bUL())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.oDm.bUN())
      {
        if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.oLE instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.oDm.bVc().mwj)
      {
      default: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.a(this.oDq);
        break;
      case 0: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.c(this.oDq);
        break;
      case 10: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.e(this.oDq);
        break;
      case 11: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.b(this.oDq);
        break;
      case 20: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.f(this.oDq);
        break;
      case 30: 
        this.oLE = new com.tencent.mm.plugin.card.ui.a.d(this.oDq);
      }
    }
  }
  
  private void bXL()
  {
    AppMethodBeat.i(113285);
    if ((this.oDm.bVc().GkC != null) && (this.oDm.bVc().GkC.Gwf))
    {
      this.oLL = new com.tencent.mm.plugin.card.ui.view.m();
      am.bWs().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.oDm.bVc().mwj == 10)
    {
      this.oLL = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.oLL = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void bXM()
  {
    AppMethodBeat.i(113286);
    if (this.dus)
    {
      ae.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.oDm.bUH()) && (this.oDm.bUJ()))
    {
      this.iFK.findViewById(2131297787).setBackgroundColor(this.oDq.getResources().getColor(2131101179));
      this.oDq.setActionbarColor(this.oDq.getResources().getColor(2131101179));
      localObject2 = this.iFK.findViewById(2131299042);
      localObject1 = this.iFK.findViewById(2131300735);
      localView = this.iFK.findViewById(2131299039);
      if ((!this.oDm.bUH()) || (!this.oLE.bYR())) {
        break label1267;
      }
      if (!this.oDm.bUK()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(2131231515);
      this.iFK.findViewById(2131300307).setBackgroundResource(2131231456);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.oDm.bUN())
      {
        localObject3 = (TextView)this.iFK.findViewById(2131297477);
        localObject4 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.h.aaZ(2131231510));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.oDm.bUI()) && (this.oLE.bYP()) && (this.oLG))
      {
        localObject4 = this.iFK.findViewById(2131304758);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.oDm.bUH()) && (this.oLE.bYR()))
      {
        localObject4 = this.iFK.findViewById(2131300307);
        ((Rect)localObject3).left = this.oDq.getResources().getDimensionPixelOffset(2131165480);
        ((Rect)localObject3).right = this.oDq.getResources().getDimensionPixelOffset(2131165480);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.oDm.bUL())
        {
          localObject3 = this.iFK.findViewById(2131300308);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.oDq.getResources().getDimensionPixelSize(2131165568);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.oLE.bYR()) && (!this.oLE.bYP())) {
        break label1491;
      }
      if ((this.oLJ != null) && (((this.oDm.bUH()) && (this.oDm.bUK())) || (this.oDm.bUI()))) {
        this.oLJ.Bc(0);
      }
      label650:
      if ((this.oLJ != null) && (this.oDm.bUH()) && (this.oDm.bUJ()))
      {
        i = this.oDq.getResources().getDimensionPixelOffset(2131165983);
        localObject3 = com.tencent.mm.plugin.card.d.l.eV(com.tencent.mm.plugin.card.d.l.ZY(this.oDm.bVc().hDr), i);
        this.oLJ.a((ShapeDrawable)localObject3);
      }
      if ((this.oDm.bUH()) && (this.oDm.bUJ()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.oDm.bVc().Gki)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.oDq.getResources().getDimensionPixelSize(2131165500);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.oDm.bUJ()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.oDq.getResources().getDimensionPixelSize(2131165489);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.oDq.getResources().getDimensionPixelSize(2131165490);
        i = this.oDq.getResources().getDimensionPixelSize(2131165483);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.oDm.bUJ()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.oDq.getResources().getDimensionPixelSize(2131165483);
        }
        if (TextUtils.isEmpty(this.oDm.bVc().Gki)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.oDm.bVc().Gki))
      {
        localView = findViewById(2131296509);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.iFK.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.ZY(this.oDm.bVc().hDr);
      this.iFK.findViewById(2131297787).setBackgroundColor(i);
      this.oDq.setActionbarColor(i);
      break;
      label1133:
      if (this.oDm.bUJ())
      {
        this.iFK.findViewById(2131300307).setBackgroundResource(0);
        localView.setBackgroundColor(this.oDq.getResources().getColor(2131101179));
        break label197;
      }
      if (this.oDm.bUL())
      {
        ((View)localObject2).setBackgroundResource(2131231515);
        this.iFK.findViewById(2131300307).setBackgroundResource(2131231456);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.oDm.bUM()) || (!this.oDm.bUN())) {
        break label197;
      }
      localView.setBackgroundColor(this.oDq.getResources().getColor(2131101179));
      break label197;
      label1267:
      if (this.oDm.bUI())
      {
        if ((this.oLE.bYP()) && (this.oLG))
        {
          ((View)localObject2).setBackgroundResource(2131231515);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.oLE.bYP()) && (!this.oLG))
        {
          ((View)localObject2).setBackgroundResource(2131231511);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.oLE.bXY())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.oDm.bUK())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.oLE.bXY())
        {
          localView.setBackgroundResource(2131231511);
          break label197;
        }
        localView.setBackgroundResource(2131231515);
        break label197;
      }
      if (this.oDm.bUL())
      {
        ((View)localObject2).setBackgroundResource(2131231519);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.oDq.getResources().getColor(2131101179));
      break label197;
      label1491:
      if ((this.oLJ == null) || (((!this.oDm.bUH()) || (!this.oDm.bUK())) && (!this.oDm.bUI()))) {
        break label650;
      }
      if (this.oLE.bXY())
      {
        this.oLJ.Bc(2131231516);
        break label650;
      }
      this.oLJ.Bc(2131231514);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.oDq.getResources().getDimensionPixelSize(2131165198);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void bXN()
  {
    AppMethodBeat.i(113290);
    if (!this.oLE.bYT())
    {
      ae.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.oDr.clear();
    this.oDr.addAll(this.oLZ.bVD());
    this.oLM.setData(this.oDr);
    this.oLM.oQG = this.oDm.bUN();
    this.oLM.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void bXO()
  {
    AppMethodBeat.i(113291);
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (bXP()) {
      bXR();
    }
    if (this.oLJ == null) {
      bXQ();
    }
    if (this.oLJ != null)
    {
      if (this.oDm.bUL()) {
        ((com.tencent.mm.plugin.card.widget.f)this.oLJ).oDt = this.oDt;
      }
      this.oLJ.d(this.oDm);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean bXP()
  {
    AppMethodBeat.i(113292);
    if (this.oLJ == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.oDm.bUJ())
    {
      if ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.oDm.bUM())
    {
      if ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.oDm.bUK())
    {
      if ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.oDm.bUL())
    {
      if ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.oDm.bUN())
    {
      if ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.d))
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
  
  private void bXQ()
  {
    AppMethodBeat.i(113293);
    if (this.oDm.bUJ()) {
      this.oLJ = new com.tencent.mm.plugin.card.widget.e(this.oDq);
    }
    for (;;)
    {
      this.oLJ.i(this.oDm);
      View localView = this.oLJ.jq();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.oLK);
      }
      this.oLK.invalidate();
      this.oLJ.setOnClickListener(this.jwB);
      I(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.oDm.bUM()) {
        this.oLJ = new com.tencent.mm.plugin.card.widget.c(this.oDq);
      } else if (this.oDm.bUK()) {
        this.oLJ = new com.tencent.mm.plugin.card.widget.b(this.oDq);
      } else if (this.oDm.bUL()) {
        this.oLJ = new com.tencent.mm.plugin.card.widget.f(this.oDq);
      } else if (this.oDm.bUN()) {
        this.oLJ = new com.tencent.mm.plugin.card.widget.d(this.oDq);
      } else {
        this.oLJ = new com.tencent.mm.plugin.card.widget.b(this.oDq);
      }
    }
  }
  
  private void bXR()
  {
    AppMethodBeat.i(113294);
    View localView = this.oLJ.jq();
    if (localView != null) {
      this.oLK.removeView(localView);
    }
    this.oLK.removeAllViews();
    this.oLK.invalidate();
    this.oLJ.release();
    this.oLJ = null;
    AppMethodBeat.o(113294);
  }
  
  private void bXS()
  {
    AppMethodBeat.i(113295);
    if ((this.oLJ != null) && ((this.oLJ instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.oLJ).bXS();
    }
    AppMethodBeat.o(113295);
  }
  
  private void bXT()
  {
    AppMethodBeat.i(113296);
    st localst = this.oDm.bVd();
    this.oDm.a(localst);
    com.tencent.mm.plugin.card.d.l.h(this.oDm);
    AppMethodBeat.o(113296);
  }
  
  private void bXU()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.oMc.clear();
    this.oMe.clear();
    if (this.oDm.bUQ())
    {
      this.oMe.add(getString(2131757029));
      this.oMc.put(Integer.valueOf(0), "menu_func_share_friend");
      this.oMe.add(getString(2131757028));
      this.oMc.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.oDm.bVd().GhS))
    {
      this.oMe.add(getString(2131756938));
      this.oMc.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    AN(j);
    if (this.oMe.size() > 0) {
      this.oDq.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void bXV()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.oMc.clear();
    this.oMe.clear();
    int i = j;
    if (this.oDm.bUH())
    {
      i = j;
      if (this.oDm.bUP())
      {
        if (bu.isNullOrNil(this.oDm.bVc().GkJ)) {
          break label235;
        }
        this.oMe.add(this.oDm.bVc().GkJ);
        this.oMc.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.oDm.bVd().GhS))
    {
      this.oMe.add(getString(2131756938));
      this.oMc.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.oDm.bUH())
    {
      this.oMe.add(getString(2131755707));
      this.oMc.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      AN(i);
      if (this.oMe.size() > 0) {
        this.oDq.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.oDm.bUN())
      {
        this.oMe.add(getString(2131756937));
        break;
      }
      this.oMe.add(getString(2131756936));
      break;
      i = j;
      if (this.oDm.bUI())
      {
        String str1 = v.aAC();
        String str2 = this.oDm.bVi();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.oMe.add(getString(2131755707));
          this.oMc.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          ae.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void bXW()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.oMc.clear();
    this.oMe.clear();
    if (!TextUtils.isEmpty(this.oDm.bVd().GhS))
    {
      this.oMe.add(getString(2131756938));
      this.oMc.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    AN(i);
    if (this.oMe.size() > 0) {
      this.oDq.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.oLE.bYO())
    {
      this.oDq.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.oDq.setMMTitle(this.oLZ.getTitle());
    AppMethodBeat.o(113289);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<tn> paramArrayList)
  {
    this.oDm = paramb;
    this.oMg = parama;
    this.oDt = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.oDm.bVd().GhW;
      if (this.oDm.bUV())
      {
        com.tencent.mm.plugin.card.d.b.a(this.oDq, paramb.oEe, paramb.oEf, paramBoolean2, this.oDm);
        com.tencent.mm.plugin.report.service.g.yxI.f(11941, new Object[] { Integer.valueOf(17), this.oDm.bVg(), this.oDm.bVh(), "", this.oDm.bVd().GhW.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aai)localObject1).GjJ)) && (!TextUtils.isEmpty(((aai)localObject1).GjK)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.oDm.bVg(), (aai)localObject1, this.oMg.oIS, this.oMg.oMm);
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        str1 = this.oDm.bVg();
        str2 = this.oDm.bVh();
        if (((aai)localObject1).title != null) {}
        for (paramb = ((aai)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aai)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.Z(((aai)localObject1).url, ((aai)localObject1).GkZ);
        com.tencent.mm.plugin.card.d.b.a(this.oDq, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.g.yxI;
        str1 = this.oDm.bVg();
        str2 = this.oDm.bVh();
        if (((aai)localObject1).title != null) {}
        for (paramb = ((aai)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.g)localObject2).f(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
      j = this.oDm.bVc().mwj;
      localObject2 = this.oDm.bVh();
      str1 = this.oDm.bVg();
      k = this.oMg.oIS;
      str2 = this.oMg.oLo;
      if (this.oDm.bVa()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        ZB(paramb.oEb);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
    int k = this.oDm.bVc().mwj;
    Object localObject2 = this.oDm.bVh();
    String str1 = this.oDm.bVg();
    int m = this.oMg.oIS;
    String str2 = this.oMg.oLo;
    if (this.oDm.bVa()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject1).f(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      ZB(paramb.oEb);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    ae.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oMs = b.oMq;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(2131756842);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.oMh.sendMessage(localMessage);
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
      this.oDm = paramb;
      if (this.oMf != null) {
        this.oMf.b(paramb);
      }
      bWN();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    ae.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oMs = b.oMp;
    localc.oMt = paramc;
    localMessage.obj = localc;
    this.oMh.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void bVH()
  {
    AppMethodBeat.i(113283);
    ae.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oMs = b.oMo;
    localMessage.obj = localc;
    this.oMh.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void bWN()
  {
    AppMethodBeat.i(113280);
    if (this.oDm == null)
    {
      ae.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.oMf != null) {
        this.oMf.bXx();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.oDm.bVc() == null)
    {
      ae.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.oMf != null) {
        this.oMf.bXx();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.oDm.bVd() == null)
    {
      ae.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.oMf != null) {
        this.oMf.bXx();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.oDm.bUO())
    {
      ae.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.oDm.bVc().mwj) });
      if (!TextUtils.isEmpty(this.oDm.bVc().Gkd))
      {
        com.tencent.mm.plugin.card.d.b.a(this.oDq, this.oDm.bVc().Gkd, 0);
        if (this.oMf != null)
        {
          this.oMf.bXx();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.oDq, getString(2131756947), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.this.oMf != null) {
              e.this.oMf.bXx();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    ae.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    ae.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.oDm.bVc().Gky);
    this.oLZ.a(this.oDm, this.oDt, this.oMg.fRv);
    bXK();
    this.oLE.bZg();
    ae.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    bXO();
    if (this.oLE.bYP())
    {
      ae.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.oLF.update();
      if (!this.oLE.bYG()) {
        break label1156;
      }
      if (this.oLW == null)
      {
        this.oLW = new com.tencent.mm.plugin.card.ui.view.b();
        this.oLW.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.oLW.update();
      label436:
      this.oDq.showOptionMenu(this.oLE.bYK());
      if (this.oLE.bYL()) {
        bXU();
      }
      if (this.oLE.bYM()) {
        bXV();
      }
      if (this.oLE.bYN()) {
        bXW();
      }
      bXS();
      I(this.oLE.bYI(), this.oLE.bYJ());
      if ((this.oDm.bUJ()) || (!this.oLE.bYR())) {
        break label1181;
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.oLH.update();
      label565:
      if (this.oLJ != null) {
        this.oLJ.jB(this.oLE.bXY());
      }
      bXM();
      if (!this.oLE.bYW()) {
        break label1278;
      }
      if (this.oLO == null)
      {
        this.oLO = new y();
        this.oLO.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.oLO.update();
      label647:
      if (!this.oLE.bZf()) {
        break label1303;
      }
      if (this.oLN == null)
      {
        this.oLN = new com.tencent.mm.plugin.card.ui.view.c();
        this.oLN.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.oLN.update();
      label700:
      if (!this.oLE.bYX()) {
        break label1328;
      }
      if (this.oLP == null)
      {
        this.oLP = new k();
        this.oLP.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.oLP.update();
      label753:
      if (!this.oLE.bYY()) {
        break label1353;
      }
      if (this.oLQ == null)
      {
        this.oLQ = new w();
        this.oLQ.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.oLQ.update();
      label806:
      if (!this.oLE.bYZ()) {
        break label1378;
      }
      if (this.oLR == null)
      {
        this.oLR = new com.tencent.mm.plugin.card.ui.view.l();
        this.oLR.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.oLR.update();
      label859:
      if (!this.oLE.bZa()) {
        break label1403;
      }
      if (this.oLS == null)
      {
        this.oLS = new com.tencent.mm.plugin.card.ui.view.z();
        this.oLS.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.oLS.update();
      label912:
      if (!this.oLE.bZc()) {
        break label1428;
      }
      if (this.oLT == null)
      {
        this.oLT = new com.tencent.mm.plugin.card.ui.view.e();
        this.oLT.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.oLT.update();
      label965:
      if (!this.oLE.bZb()) {
        break label1453;
      }
      if (this.oLU == null)
      {
        this.oLU = new com.tencent.mm.plugin.card.ui.view.u();
        this.oLU.a(this);
      }
      ae.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.oLU.update();
      label1018:
      bXN();
      if (!this.oLE.bYU()) {
        break label1530;
      }
      bXT();
      if (!this.oLE.bYV()) {
        break label1513;
      }
      if (this.oLL != null) {
        break label1478;
      }
      bXL();
      this.oLL.a(this);
      this.oLL.update();
      label1076:
      if (this.oLJ != null) {
        this.oLJ.jA(true);
      }
      label1093:
      if (!this.oLE.bZd()) {
        break label1572;
      }
      ae.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.oLV.update();
    }
    for (;;)
    {
      this.oLX.oDm = this.oDm;
      AppMethodBeat.o(113280);
      return;
      ae.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.oLF.bZG();
      break;
      label1156:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.oLW == null) {
        break label436;
      }
      this.oLW.bZG();
      break label436;
      label1181:
      if ((this.oDm.bUJ()) && (this.oLE.bYR()))
      {
        ae.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.oLI.update();
        break label565;
      }
      if (this.oLE.bYS())
      {
        ae.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.oLI.update();
        break label565;
      }
      ae.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.oLI.bZG();
      this.oLH.bZG();
      break label565;
      label1278:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.oLO == null) {
        break label647;
      }
      this.oLO.bZG();
      break label647;
      label1303:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.oLN == null) {
        break label700;
      }
      this.oLN.bZG();
      break label700;
      label1328:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.oLP == null) {
        break label753;
      }
      this.oLP.bZG();
      break label753;
      label1353:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.oLQ == null) {
        break label806;
      }
      this.oLQ.bZG();
      break label806;
      label1378:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.oLR == null) {
        break label859;
      }
      this.oLR.bZG();
      break label859;
      label1403:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.oLS == null) {
        break label912;
      }
      this.oLS.bZG();
      break label912;
      label1428:
      ae.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.oLT == null) {
        break label965;
      }
      this.oLT.bZG();
      break label965;
      label1453:
      ae.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.oLU == null) {
        break label1018;
      }
      this.oLU.bZG();
      break label1018;
      label1478:
      if (!this.oLL.f(this.oDm)) {
        break label1076;
      }
      this.oLL.b(this.oDm);
      this.oLL.update();
      break label1076;
      label1513:
      if (this.oLL == null) {
        break label1076;
      }
      this.oLL.bZL();
      break label1076;
      label1530:
      ae.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.oLL != null) {
        this.oLL.bZL();
      }
      if (this.oLJ == null) {
        break label1093;
      }
      this.oLJ.jA(false);
      break label1093;
      label1572:
      ae.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.oLV.bZG();
    }
  }
  
  public final com.tencent.mm.plugin.card.base.b bXA()
  {
    return this.oDm;
  }
  
  public final boolean bXB()
  {
    return this.oLG;
  }
  
  public final void bXC()
  {
    this.oLG = false;
  }
  
  public final MMActivity bXD()
  {
    return this.oDq;
  }
  
  public final View.OnClickListener bXE()
  {
    return this.jwB;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g bXF()
  {
    return this.oLE;
  }
  
  public final d bXG()
  {
    return this.oMf;
  }
  
  public final a bXH()
  {
    return this.oMg;
  }
  
  public final com.tencent.mm.plugin.card.b.f bXI()
  {
    return this.oLZ;
  }
  
  public final j bXJ()
  {
    return this.oLX;
  }
  
  public final int bXX()
  {
    AppMethodBeat.i(113304);
    if (this.oLZ == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.oLZ.bVF())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean bXY()
  {
    AppMethodBeat.i(113305);
    if (this.oLE == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.oLE.bXY();
    AppMethodBeat.o(113305);
    return bool;
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
        this.oMa = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.oMa;
        if ((this.oDm == null) || (this.oDm.bVc() == null))
        {
          ae.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.oDm.bVe().HLH)) && (!this.oDm.bUN())) {
            localStringBuilder.append(this.oDm.bVe().HLH);
          }
        }
        for (;;)
        {
          String str = this.oDm.bVc().title + "\n" + this.oDm.bVc().oFG;
          ab.a.Fpw.a(this.oDq.getController(), localStringBuilder.toString(), this.oDm.bVc().hCp, str, true, this.oDq.getResources().getString(2131755884), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.oMb = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.this.oMf != null) {
                    e.this.oMf.ZA(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.this.oDm.bVc().mwj), e.this.oDm.bVh(), e.this.oDm.bVg(), e.this.oMa });
                  com.tencent.mm.ui.base.h.cm(e.this.oDq, e.this.oDq.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  paramAnonymousString = e.this;
                  paramAnonymousString.oDm.bVe().HLH = (paramAnonymousString.getString(2131756994) + paramAnonymousString.oLZ.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.oDm, paramAnonymousString.oMa, paramAnonymousString.oMg.oLq, 2);
                  com.tencent.mm.plugin.card.d.l.fk(paramAnonymousString.oMb, paramAnonymousString.oMa);
                  com.tencent.mm.ui.base.h.cm(e.this.oDq, e.this.oDq.getResources().getString(2131756873));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  paramAnonymousString = e.this;
                  if (TextUtils.isEmpty(paramAnonymousString.oDm.bVi())) {
                    paramAnonymousString.oDm.YT(v.aAC());
                  }
                  paramAnonymousString.oDm.bVe().HLH = (paramAnonymousString.getString(2131756955) + paramAnonymousString.oLZ.getTitle());
                  com.tencent.mm.plugin.card.d.l.a(paramAnonymousString.oDm, paramAnonymousString.oMa, paramAnonymousString.oMg.oLq, 23);
                  com.tencent.mm.plugin.card.d.l.fk(paramAnonymousString.oMb, paramAnonymousString.oMa);
                  com.tencent.mm.plugin.report.service.g.yxI.f(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.this.oMg.fRv), Integer.valueOf(e.this.oDm.bVc().mwj), e.this.oDm.bVh(), e.this.oDm.bVg(), e.this.oMa });
                  com.tencent.mm.ui.base.h.cm(e.this.oDq, e.this.oDq.getResources().getString(2131756873));
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
            localStringBuilder.append(getString(2131756994) + this.oLZ.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(2131756955) + this.oLZ.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.oJt = paramIntent.getIntExtra("Ktag_range_index", 0);
        ae.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.oJt) });
        if (this.oJt >= 2)
        {
          this.oJu = paramIntent.getStringExtra("Klabel_name_list");
          this.oJv = paramIntent.getStringExtra("Kother_user_name_list");
          ae.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.oJt), this.oJu });
          if ((TextUtils.isEmpty(this.oJu)) && (TextUtils.isEmpty(this.oJv)))
          {
            ae.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.oJu.split(","));
          this.oJx = com.tencent.mm.plugin.card.d.l.cK(paramIntent);
          this.oJw = com.tencent.mm.plugin.card.d.l.cJ(paramIntent);
          if ((this.oJv != null) && (this.oJv.length() > 0))
          {
            paramIntent = Arrays.asList(this.oJv.split(","));
            this.oJw.addAll(paramIntent);
          }
          if (this.oJx != null) {
            ae.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.oJx.size());
          }
          if (this.oJw != null)
          {
            ae.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.oJw.size());
            paramIntent = this.oJw.iterator();
            while (paramIntent.hasNext()) {
              ae.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.oJt == 2)
          {
            this.oLV.ZO(this.oDq.getString(2131756982, new Object[] { bWP() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.oJt == 3)
          {
            this.oLV.ZO(this.oDq.getString(2131756981, new Object[] { bWP() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.oLV.ZO(this.oDq.getString(2131756980));
          AppMethodBeat.o(113301);
          return;
        }
        this.oLV.ZO(this.oDq.getString(2131756980));
        AppMethodBeat.o(113301);
        return;
        if (this.oMf != null) {
          this.oMf.bXz();
        }
      }
    }
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    ae.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.oMs = b.oMn;
    localc.oMt = paramc;
    localMessage.obj = localc;
    this.oMh.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.iFK.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.oDq.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int fRv = 3;
    public String oCY = "";
    public boolean oEy = false;
    public int oIS = -1;
    public String oKV = "";
    public String oKW = "";
    public String oLo = "";
    public String oLp = "";
    public String oLq = "";
    public int oMm = 0;
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(113274);
      oMn = new b("onGetCodeSuccess", 0);
      oMo = new b("onShowTimeExpired", 1);
      oMp = new b("onReceiveCodeUnavailable", 2);
      oMq = new b("onGetCodeFail", 3);
      oMr = new b[] { oMn, oMo, oMp, oMq };
      AppMethodBeat.o(113274);
    }
    
    private b() {}
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b oMs;
    com.tencent.mm.plugin.card.d.c oMt;
  }
  
  public static abstract interface d
  {
    public abstract void ZA(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void bXt();
    
    public abstract void bXu();
    
    public abstract void bXv();
    
    public abstract void bXw();
    
    public abstract void bXx();
    
    public abstract void bXy();
    
    public abstract void bXz();
    
    public abstract void jv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */