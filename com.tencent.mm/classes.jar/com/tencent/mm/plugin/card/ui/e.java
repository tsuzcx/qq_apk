package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
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
import android.view.ViewOutlineProvider;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.d.a;
import com.tencent.mm.plugin.card.mgr.f.a;
import com.tencent.mm.plugin.card.mgr.i.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.ui.applet.ac;
import com.tencent.mm.pluginsdk.ui.applet.ac.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.bj;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements f.a, n, MMActivity.a
{
  private final String TAG;
  boolean hJi;
  ListView mListView;
  private View plc;
  View.OnClickListener qjL;
  i wAa;
  i wAb;
  i wAc;
  com.tencent.mm.plugin.card.ui.view.d wAd;
  i wAe;
  j wAf;
  private boolean wAg;
  com.tencent.mm.plugin.card.mgr.e wAh;
  public String wAi;
  public String wAj;
  private HashMap<Integer, String> wAk;
  private HashMap<String, a> wAl;
  private ArrayList<String> wAm;
  e wAn;
  private b wAo;
  private MMHandler wAp;
  IListener wAq;
  private ArrayList<wl> wrB;
  com.tencent.mm.plugin.card.base.b wru;
  MMActivity wry;
  private List<com.tencent.mm.plugin.card.model.b> wrz;
  public int wxB;
  private String wxC;
  private String wxD;
  public ArrayList<String> wxE;
  public ArrayList<String> wxF;
  com.tencent.mm.plugin.card.ui.a.g wzM;
  i wzN;
  private boolean wzO;
  i wzP;
  i wzQ;
  com.tencent.mm.plugin.card.widget.g wzR;
  LinearLayout wzS;
  com.tencent.mm.plugin.card.ui.view.g wzT;
  m wzU;
  i wzV;
  i wzW;
  i wzX;
  i wzY;
  i wzZ;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.wzO = false;
    this.wAg = true;
    this.wrz = new ArrayList();
    this.wAi = "";
    this.wAj = "";
    this.wxB = 0;
    this.wxC = "";
    this.wxD = "";
    this.wxE = new ArrayList();
    this.wxF = new ArrayList();
    this.wAk = new HashMap();
    this.wAl = new HashMap();
    this.wAm = new ArrayList();
    this.hJi = false;
    this.wAp = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.d)))
        {
          paramAnonymousMessage = (e.d)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.wAA == e.c.wAy)
          {
            if (e.k(e.this) != null)
            {
              com.tencent.mm.plugin.card.c.d.a(e.c(e.this), paramAnonymousMessage.errMsg, false);
              e.k(e.this).doH();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.wAA == e.c.wAw)
          {
            if (e.k(e.this) != null)
            {
              e.k(e.this).d(com.tencent.mm.plugin.card.c.c.wKk);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.k(e.this) != null) {
            e.k(e.this).d(paramAnonymousMessage.wAB);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.qjL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(293836);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getId() == a.d.wfj) || (paramAnonymousView.getId() == a.d.fvn)) {
          if (e.b(e.this).djo()) {
            if (e.j(e.this) != null) {
              e.j(e.this).dmg();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(293836);
          return;
          if ((e.b(e.this).djp()) && (e.j(e.this) != null))
          {
            e.j(e.this).dme();
            continue;
            if ((paramAnonymousView.getId() == a.d.wkb) || (paramAnonymousView.getId() == a.d.weH))
            {
              com.tencent.mm.plugin.card.c.b.an(e.c(e.this), e.d(e.this).wzv);
            }
            else if ((paramAnonymousView.getId() == a.d.wjz) || (paramAnonymousView.getId() == a.d.wjq))
            {
              if (paramAnonymousView.getId() == a.d.wjz)
              {
                e.a(e.this, false);
                label237:
                if ((e.k(e.this) instanceof q))
                {
                  localObject = ((q)e.k(e.this)).e(com.tencent.mm.plugin.card.c.c.wKm);
                  e.l(e.this).wEh = ((String)localObject);
                }
                localObject = e.l(e.this);
                bool = e.m(e.this);
                ((j)localObject).dna();
                ((j)localObject).wAg = bool;
                if ((((j)localObject).qjH == null) || (((j)localObject).qjH.isShowing())) {
                  continue;
                }
                ((j)localObject).qjH.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).qjH.setFocusable(true);
                ((j)localObject).qjH.setTouchable(true);
                ((j)localObject).qjH.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).qjH.setOutsideTouchable(true);
                if (!((j)localObject).wAg) {
                  break label786;
                }
                ((j)localObject).wEd.setOnClickListener(((j)localObject).qjL);
                paramAnonymousView = ((j)localObject).wDZ;
                if (((j)localObject).wwO == null) {
                  break label698;
                }
                ((j)localObject).wDZ = com.tencent.mm.plugin.card.c.l.ag(((j)localObject).wwO);
                label437:
                ((j)localObject).wEd.setImageBitmap(((j)localObject).wDZ);
                ((j)localObject).wEg.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).qjJ.setVisibility(8);
                ((j)localObject).wEc.setVisibility(0);
                paramAnonymousView = ((j)localObject).wru.djL().code;
                if ((((j)localObject).wru.djK().Zeo != null) && (((j)localObject).wru.djK().Zeo.Zsw)) {
                  break label740;
                }
                if (Util.isNullOrNil(((j)localObject).wru.djL().ZbL)) {
                  break label707;
                }
                paramAnonymousView = ((j)localObject).wru.djL().ZbL;
                label566:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label760;
                }
                ((j)localObject).wEe.setText(com.tencent.mm.plugin.card.c.n.alC(paramAnonymousView));
                if (!((j)localObject).wru.djy()) {
                  break label747;
                }
                ((j)localObject).wEe.setVisibility(0);
                label616:
                if (Util.isNullOrNil(((j)localObject).wru.djK().pHt)) {
                  break label773;
                }
                ((j)localObject).wEf.setText(((j)localObject).wru.djK().pHt);
                ((j)localObject).wEf.setVisibility(0);
              }
              for (;;)
              {
                ((j)localObject).qjH.update();
                break;
                if (paramAnonymousView.getId() != a.d.wjq) {
                  break label237;
                }
                e.a(e.this, true);
                break label237;
                label698:
                ((j)localObject).wDZ = null;
                break label437;
                label707:
                if (!((j)localObject).wru.djD()) {
                  break label566;
                }
                if (!Util.isNullOrNil(((j)localObject).wEh))
                {
                  paramAnonymousView = ((j)localObject).wEh;
                  break label566;
                }
                label740:
                paramAnonymousView = "";
                break label566;
                label747:
                ((j)localObject).wEe.setVisibility(8);
                break label616;
                label760:
                ((j)localObject).wEe.setVisibility(8);
                break label616;
                label773:
                ((j)localObject).wEf.setVisibility(8);
              }
              label786:
              ((j)localObject).qjI.setOnClickListener(((j)localObject).qjL);
              ((j)localObject).qjI.setImageBitmap(((j)localObject).qjG);
              paramAnonymousView = ((j)localObject).wru.djL().code;
              if ((((j)localObject).wru.djK().Zeo == null) || (!((j)localObject).wru.djK().Zeo.Zsw)) {
                if (!Util.isNullOrNil(((j)localObject).wru.djL().ZbL))
                {
                  paramAnonymousView = ((j)localObject).wru.djL().ZbL;
                  label894:
                  if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                    break label1068;
                  }
                  ((j)localObject).wEa.setText(com.tencent.mm.plugin.card.c.n.alC(paramAnonymousView));
                  if (!((j)localObject).wru.djy()) {
                    break label1055;
                  }
                  ((j)localObject).wEa.setVisibility(0);
                  label944:
                  if (TextUtils.isEmpty(((j)localObject).wru.djK().pHt)) {
                    break label1081;
                  }
                  ((j)localObject).wEb.setText(((j)localObject).wru.djK().pHt);
                  ((j)localObject).wEb.setVisibility(0);
                }
              }
              for (;;)
              {
                ((j)localObject).qjJ.setVisibility(0);
                ((j)localObject).wEc.setVisibility(8);
                break;
                if (!((j)localObject).wru.djD()) {
                  break label894;
                }
                if (!Util.isNullOrNil(((j)localObject).wEh))
                {
                  paramAnonymousView = ((j)localObject).wEh;
                  break label894;
                }
                paramAnonymousView = "";
                break label894;
                label1055:
                ((j)localObject).wEa.setVisibility(8);
                break label944;
                label1068:
                ((j)localObject).wEa.setVisibility(8);
                break label944;
                label1081:
                ((j)localObject).wEb.setVisibility(8);
              }
            }
            else
            {
              int j;
              String str1;
              int k;
              String str2;
              int i;
              if ((paramAnonymousView.getId() == a.d.wfT) || (paramAnonymousView.getId() == a.d.wfO) || (paramAnonymousView.getId() == a.d.wfN) || (paramAnonymousView.getId() == a.d.wjG) || (paramAnonymousView.getId() == a.d.wfM))
              {
                if (paramAnonymousView.getId() == a.d.wfT)
                {
                  if (e.b(e.this).djp())
                  {
                    paramAnonymousView = com.tencent.mm.plugin.report.service.h.OAn;
                    j = e.b(e.this).djK().tNW;
                    localObject = e.b(e.this).djP();
                    str1 = e.b(e.this).djO();
                    k = e.d(e.this).wxa;
                    str2 = e.d(e.this).wzv;
                    if (e.b(e.this).djI()) {}
                    for (i = 1;; i = 0)
                    {
                      paramAnonymousView.b(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                      if (e.j(e.this) == null) {
                        break;
                      }
                      e.j(e.this).nd(true);
                      break;
                    }
                  }
                  paramAnonymousView = new i.b();
                  e.this.a(true, paramAnonymousView, false);
                }
                else
                {
                  if ((paramAnonymousView.getId() == a.d.wjG) && (e.b(e.this).djK().Zer))
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(293836);
                    return;
                  }
                  if (e.b(e.this).djp())
                  {
                    if (e.j(e.this) != null) {
                      e.j(e.this).nd(false);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new i.b();
                    e.this.a(false, paramAnonymousView, false);
                  }
                }
              }
              else if (paramAnonymousView.getId() == a.d.weN)
              {
                if (!TextUtils.isEmpty(e.b(e.this).djK().Zew))
                {
                  com.tencent.mm.plugin.card.c.b.S(e.b(e.this).djK().Zew, e.b(e.this).djK().Zex, 0);
                  com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(13), e.b(e.this).djO(), e.b(e.this).djP(), "", e.b(e.this).djK().ZdU });
                }
                else if (!TextUtils.isEmpty(e.b(e.this).djK().ZdV))
                {
                  com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().ZdV, 3);
                  com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(13), e.b(e.this).djO(), e.b(e.this).djP(), "", e.b(e.this).djK().ZdU });
                }
              }
              else if (paramAnonymousView.getId() == a.d.whv)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.b(e.this).djK().tNW), e.b(e.this).djP(), e.b(e.this).djO(), e.d(e.this).wzv });
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KLabel_range_index", e.this.wxB);
                paramAnonymousView.putExtra("Klabel_name_list", e.n(e.this));
                paramAnonymousView.putExtra("Kother_user_name_list", e.o(e.this));
                paramAnonymousView.putExtra("k_sns_label_ui_title", e.c(e.this).getString(a.g.wqc));
                paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
                paramAnonymousView.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.br.c.b(e.c(e.this), "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
                e.c(e.this).mmSetOnActivityResultCallback(e.this);
              }
              else if (paramAnonymousView.getId() == a.d.whE)
              {
                if (e.b(e.this).djL().Zbz != null)
                {
                  localObject = e.b(e.this).djL().Zbz;
                  i = ((Integer)paramAnonymousView.getTag()).intValue();
                  paramAnonymousView = (aek)((LinkedList)localObject).get(i);
                  if (com.tencent.mm.plugin.card.c.b.a(e.b(e.this).djO(), paramAnonymousView, e.d(e.this).wxa, e.d(e.this).wAu))
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(19), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(e.Iv(i)), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.c.l.a(paramAnonymousView, e.b(e.this).djO()))
                    {
                      com.tencent.mm.plugin.card.c.l.alA(e.b(e.this).djO());
                      com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().mee);
                    }
                  }
                }
              }
              else if (paramAnonymousView.getId() == a.d.whF)
              {
                if (e.b(e.this).djL().Zbz != null)
                {
                  paramAnonymousView = (aek)e.b(e.this).djL().Zbz.get(0);
                  if (com.tencent.mm.plugin.card.c.b.a(e.b(e.this).djO(), paramAnonymousView, e.d(e.this).wxa, e.d(e.this).wAu))
                  {
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(19), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(10), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.c.l.a(paramAnonymousView, e.b(e.this).djO()))
                    {
                      com.tencent.mm.plugin.card.c.l.alA(e.b(e.this).djO());
                      com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().mee);
                    }
                  }
                }
              }
              else if ((paramAnonymousView.getId() == a.d.whX) || (paramAnonymousView.getId() == a.d.who))
              {
                if (e.b(e.this).djL().ZbG != null) {
                  if (e.b(e.this).djB())
                  {
                    if (e.b(e.this).djp())
                    {
                      if (e.j(e.this) != null) {
                        e.j(e.this).nd(false);
                      }
                    }
                    else
                    {
                      paramAnonymousView = new i.b();
                      e.this.a(false, paramAnonymousView, false);
                    }
                  }
                  else if (e.b(e.this).djC())
                  {
                    paramAnonymousView = new i.b();
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), paramAnonymousView.wso, paramAnonymousView.wsp, false, e.b(e.this));
                  }
                  else
                  {
                    paramAnonymousView = e.b(e.this).djL().ZbG;
                    if (com.tencent.mm.plugin.card.c.b.a(e.b(e.this).djO(), paramAnonymousView, e.d(e.this).wxa, e.d(e.this).wAu))
                    {
                      com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(20), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                    }
                    else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                    {
                      localObject = com.tencent.mm.plugin.card.c.l.ad(paramAnonymousView.url, paramAnonymousView.ZeU);
                      com.tencent.mm.plugin.card.c.b.a(e.c(e.this), (String)localObject, 1);
                      com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(9), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.title });
                      if (com.tencent.mm.plugin.card.c.l.a(paramAnonymousView, e.b(e.this).djO()))
                      {
                        com.tencent.mm.plugin.card.c.l.alA(e.b(e.this).djO());
                        com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().mee);
                      }
                    }
                  }
                }
              }
              else
              {
                String str3;
                if ((paramAnonymousView.getId() == a.d.wge) || (paramAnonymousView.getId() == a.d.wfl))
                {
                  paramAnonymousView = e.b(e.this).djK().Zeb;
                  localObject = com.tencent.mm.plugin.report.service.h.OAn;
                  j = e.b(e.this).djK().tNW;
                  str1 = e.b(e.this).djP();
                  str2 = e.b(e.this).djO();
                  k = e.d(e.this).wxa;
                  str3 = e.d(e.this).wzv;
                  if (e.b(e.this).djI()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject).b(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                      break label3316;
                    }
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    break;
                  }
                  label3316:
                  localObject = new Intent();
                  if ((e.b(e.this) instanceof CardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.b(e.this));
                  }
                  for (;;)
                  {
                    ((Intent)localObject).setClass(e.c(e.this), CardDetailPreference.class);
                    paramAnonymousView = e.c(e.this);
                    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
                    com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                    if ((e.b(e.this) instanceof ShareCardInfo)) {
                      ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.b(e.this));
                    }
                  }
                }
                if (paramAnonymousView.getId() == a.d.wlm)
                {
                  if (com.tencent.mm.plugin.card.sharecard.a.b.akK(e.b(e.this).djP()) <= 1)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(293836);
                    return;
                  }
                  paramAnonymousView = e.this;
                  if (!e.p(e.this)) {}
                  for (;;)
                  {
                    e.b(paramAnonymousView, bool);
                    e.this.dlx();
                    break;
                    bool = false;
                  }
                }
                if (paramAnonymousView.getId() == a.d.wfp)
                {
                  if ((e.b(e.this).djK().ZdX != null) && (!TextUtils.isEmpty(e.b(e.this).djK().ZdX.url)))
                  {
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().ZdX.url, 3);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(3), e.b(e.this).djO(), e.b(e.this).djP(), "", e.b(e.this).djK().ZdX.text });
                  }
                }
                else if (paramAnonymousView.getId() == a.d.wfh)
                {
                  if ((e.b(e.this).djK().Zee != null) && (!Util.isNullOrNil(e.b(e.this).djK().Zee.url)))
                  {
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), e.b(e.this).djK().Zee.url, 1);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(14), e.b(e.this).djO(), e.b(e.this).djP(), "", e.b(e.this).djK().Zee.text });
                  }
                }
                else if ((paramAnonymousView.getId() == a.d.wls) || (paramAnonymousView.getId() == a.d.wlt))
                {
                  if (e.b(e.this).djK().ZdO > 0)
                  {
                    if ((e.f(e.this) == null) || (e.f(e.this).size() == 0))
                    {
                      Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(293836);
                      return;
                    }
                    paramAnonymousView = (wl)e.f(e.this).get(0);
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), paramAnonymousView.latitude, paramAnonymousView.longitude, paramAnonymousView.oDI);
                    localObject = com.tencent.mm.plugin.report.service.h.OAn;
                    j = e.b(e.this).djK().tNW;
                    str1 = e.b(e.this).djP();
                    str2 = e.b(e.this).djO();
                    k = e.d(e.this).wxa;
                    str3 = e.d(e.this).wzv;
                    if (e.b(e.this).djI()) {}
                    for (i = 1;; i = 0)
                    {
                      ((com.tencent.mm.plugin.report.service.h)localObject).b(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                      com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(5), e.b(e.this).djO(), e.b(e.this).djP(), "", paramAnonymousView.name });
                      break;
                    }
                  }
                }
                else if (paramAnonymousView.getId() == a.d.wlF)
                {
                  if ((e.f(e.this) == null) || (e.f(e.this).size() == 0))
                  {
                    Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(293836);
                    return;
                  }
                  localObject = (wl)e.f(e.this).get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.c(e.this).getString(a.g.woi))))
                  {
                    e.e(e.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(293836);
                    return;
                  }
                  if (!TextUtils.isEmpty(((wl)localObject).jump_url))
                  {
                    com.tencent.mm.plugin.card.c.b.a(e.c(e.this), ((wl)localObject).jump_url, 1);
                    com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(4), e.b(e.this).djO(), e.b(e.this).djP(), "", ((wl)localObject).name });
                  }
                }
                else if (paramAnonymousView.getId() == a.d.wlA)
                {
                  e.e(e.this);
                }
              }
            }
          }
        }
      }
    };
    this.wAq = new CardDetailUIContoller.9(this, com.tencent.mm.app.f.hfK);
    this.wry = paramMMActivity;
    this.plc = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void Iu(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.wru.djL().ZbE;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.wAl.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < localLinkedList.size())
    {
      bj localbj = (bj)localLinkedList.get(paramInt);
      if ((!Util.isNullOrNil(localbj.url)) || (!Util.isNullOrNil(localbj.VcU))) {}
      for (int k = 1;; k = 0)
      {
        j = i;
        if (!Util.isNullOrNil(localbj.text))
        {
          j = i;
          if (k != 0)
          {
            this.wAm.add(localbj.text);
            this.wAk.put(Integer.valueOf(i), localbj.text);
            this.wAl.put(localbj.text, new a(localbj));
            j = i + 1;
          }
        }
        paramInt += 1;
        i = j;
        break;
      }
    }
    AppMethodBeat.o(113300);
  }
  
  private void P(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.wzR != null) {
      this.wzR.P(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void aMl()
  {
    AppMethodBeat.i(113289);
    if (!this.wzM.dnx())
    {
      this.wry.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.wry.setMMTitle(this.wAh.getTitle());
    AppMethodBeat.o(113289);
  }
  
  private void akY(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.wru instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.wru);
    }
    for (;;)
    {
      localIntent.setClass(this.wry, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.wAo.lCR);
      localIntent.putExtra("key_previous_scene", this.wAo.wxa);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.wAo.wAu);
      this.wry.startActivityForResult(localIntent, 3);
      this.wry.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.wru instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.wru);
      }
    }
  }
  
  private String dlz()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.wxC)) && (!TextUtils.isEmpty(this.wxD)))
    {
      str = this.wxC + "," + com.tencent.mm.plugin.card.c.l.aly(this.wxD);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxC))
    {
      str = this.wxC;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.wxD))
    {
      str = com.tencent.mm.plugin.card.c.l.aly(this.wxD);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void dmA()
  {
    AppMethodBeat.i(113293);
    if (this.wru.djq()) {
      this.wzR = new com.tencent.mm.plugin.card.widget.e(this.wry);
    }
    for (;;)
    {
      this.wzR.i(this.wru);
      View localView = this.wzR.lf();
      if (localView != null) {
        com.tencent.mm.plugin.card.c.n.a(localView, this.wzS);
      }
      this.wzS.invalidate();
      this.wzR.setOnClickListener(this.qjL);
      P(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.wru.djt()) {
        this.wzR = new com.tencent.mm.plugin.card.widget.c(this.wry);
      } else if (this.wru.djr()) {
        this.wzR = new com.tencent.mm.plugin.card.widget.b(this.wry);
      } else if (this.wru.djs()) {
        this.wzR = new com.tencent.mm.plugin.card.widget.f(this.wry);
      } else if (this.wru.dju()) {
        this.wzR = new com.tencent.mm.plugin.card.widget.d(this.wry);
      } else {
        this.wzR = new com.tencent.mm.plugin.card.widget.b(this.wry);
      }
    }
  }
  
  private void dmB()
  {
    AppMethodBeat.i(113294);
    View localView = this.wzR.lf();
    if (localView != null) {
      this.wzS.removeView(localView);
    }
    this.wzS.removeAllViews();
    this.wzS.invalidate();
    this.wzR.release();
    this.wzR = null;
    AppMethodBeat.o(113294);
  }
  
  private void dmC()
  {
    AppMethodBeat.i(113296);
    vr localvr = this.wru.djL();
    this.wru.a(localvr);
    com.tencent.mm.plugin.card.c.l.h(this.wru);
    AppMethodBeat.o(113296);
  }
  
  private void dmD()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.wAk.clear();
    this.wAm.clear();
    if (this.wru.djx())
    {
      this.wAm.add(getString(a.g.wqL));
      this.wAk.put(Integer.valueOf(0), "menu_func_share_friend");
      this.wAm.add(getString(a.g.wqK));
      this.wAk.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.wru.djL().ZbC))
    {
      this.wAm.add(getString(a.g.wpD));
      this.wAk.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    Iu(j);
    if (this.wAm.size() > 0) {
      this.wry.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void dmE()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.wAk.clear();
    this.wAm.clear();
    int i = j;
    if (this.wru.djo())
    {
      i = j;
      if (this.wru.djw())
      {
        if (Util.isNullOrNil(this.wru.djK().Zeu)) {
          break label235;
        }
        this.wAm.add(this.wru.djK().Zeu);
        this.wAk.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.wru.djL().ZbC))
    {
      this.wAm.add(getString(a.g.wpD));
      this.wAk.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.wru.djo())
    {
      this.wAm.add(getString(a.g.app_delete));
      this.wAk.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      Iu(i);
      if (this.wAm.size() > 0) {
        this.wry.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.wru.dju())
      {
        this.wAm.add(getString(a.g.wpC));
        break;
      }
      this.wAm.add(getString(a.g.wpB));
      break;
      i = j;
      if (this.wru.djp())
      {
        String str1 = com.tencent.mm.model.z.bAM();
        String str2 = this.wru.djQ();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.wAm.add(getString(a.g.app_delete));
          this.wAk.put(Integer.valueOf(j), "menu_func_delete_share_card");
          i = j + 1;
        }
        else
        {
          Log.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
          i = j;
        }
      }
    }
  }
  
  private void dmF()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.wAk.clear();
    this.wAm.clear();
    if (!TextUtils.isEmpty(this.wru.djL().ZbC))
    {
      this.wAm.add(getString(a.g.wpD));
      this.wAk.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    Iu(i);
    if (this.wAm.size() > 0) {
      this.wry.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void dmu()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.wzM == null)
    {
      i = 0;
      if (i != 0)
      {
        this.wzM.release();
        this.wzM = null;
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.wru.djK().tNW) });
      }
      if (this.wzM == null)
      {
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.wru.djK().tNW) });
        Log.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.wru.djK().tNW) });
        if (!this.wru.djp()) {
          break label423;
        }
        this.wzM = new com.tencent.mm.plugin.card.ui.a.h(this.wry);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.wru.djK().tNW) });
      this.wzM.a(this.wru, this.wAo);
      AppMethodBeat.o(113279);
      return;
      if (this.wru.djp())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.wru.djq())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.wru.djt())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.wru.djr())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.wru.djs())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.wru.dju())
      {
        if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.wzM instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.wru.djK().tNW)
      {
      default: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.a(this.wry);
        break;
      case 0: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.c(this.wry);
        break;
      case 10: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.e(this.wry);
        break;
      case 11: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.b(this.wry);
        break;
      case 20: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.f(this.wry);
        break;
      case 30: 
        this.wzM = new com.tencent.mm.plugin.card.ui.a.d(this.wry);
      }
    }
  }
  
  private void dmv()
  {
    AppMethodBeat.i(113285);
    if ((this.wru.djK().Zeo != null) && (this.wru.djK().Zeo.Zsw))
    {
      this.wzT = new com.tencent.mm.plugin.card.ui.view.m();
      am.dkZ().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.wru.djK().tNW == 10)
    {
      this.wzT = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.wzT = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void dmw()
  {
    AppMethodBeat.i(113286);
    if (this.hJi)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label204:
    Object localObject3;
    int i;
    if ((this.wru.djo()) && (this.wru.djq()))
    {
      this.plc.findViewById(a.d.wgh).setBackgroundColor(this.wry.getResources().getColor(a.a.white));
      this.wry.setActionbarColor(this.wry.getResources().getColor(a.a.white));
      localObject2 = this.plc.findViewById(a.d.wjV);
      localObject1 = this.plc.findViewById(a.d.header_view);
      localView = this.plc.findViewById(a.d.wjU);
      if ((!this.wru.djo()) || (!this.wzM.dnA())) {
        break label1274;
      }
      if (!this.wru.djr()) {
        break label1140;
      }
      ((View)localObject2).setClipToOutline(true);
      ((View)localObject2).setOutlineProvider(new ViewOutlineProvider()
      {
        public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          AppMethodBeat.i(293784);
          paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), com.tencent.mm.cd.a.br(e.this.wry, a.b.Edge_0_5_A));
          AppMethodBeat.o(293784);
        }
      });
      localView.setBackgroundColor(this.wry.getResources().getColor(a.a.UN_BW_97));
      Object localObject4;
      if (this.wru.dju())
      {
        localObject3 = (TextView)this.plc.findViewById(a.d.wfa);
        localObject4 = new BitmapDrawable(BitmapUtil.getBitmapNative(a.c.wex));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.wru.djp()) && (this.wzM.dny()) && (this.wzO))
      {
        localObject4 = this.plc.findViewById(a.d.wlj);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.wru.djo()) && (this.wzM.dnA()))
      {
        localObject4 = this.plc.findViewById(a.d.wkc);
        ((Rect)localObject3).left = this.wry.getResources().getDimensionPixelOffset(a.b.LargePadding);
        ((Rect)localObject3).right = this.wry.getResources().getDimensionPixelOffset(a.b.LargePadding);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.wru.djs())
        {
          localObject3 = this.plc.findViewById(a.d.wkd);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.wry.getResources().getDimensionPixelSize(a.b.SmallPadding);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.wzM.dnA()) && (!this.wzM.dny())) {
        break label1499;
      }
      if ((this.wzR != null) && (((this.wru.djo()) && (this.wru.djr())) || (this.wru.djp()))) {
        this.wzR.IO(0);
      }
      label657:
      if ((this.wzR != null) && (this.wru.djo()) && (this.wru.djq()))
      {
        i = this.wry.getResources().getDimensionPixelOffset(a.b.wdY);
        localObject3 = com.tencent.mm.plugin.card.c.l.gx(com.tencent.mm.plugin.card.c.l.alv(this.wru.djK().nRQ), i);
        this.wzR.a((ShapeDrawable)localObject3);
      }
      if ((this.wru.djo()) && (this.wru.djq()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.wru.djK().ZdU)) {
          break label1584;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label823:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.wry.getResources().getDimensionPixelSize(a.b.MiddlePadding);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.wru.djq()) {
          break label1599;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.wry.getResources().getDimensionPixelSize(a.b.ListPadding);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.wry.getResources().getDimensionPixelSize(a.b.LittlePadding);
        i = this.wry.getResources().getDimensionPixelSize(a.b.LargerPadding);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label939:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.wru.djq()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.wry.getResources().getDimensionPixelSize(a.b.LargerPadding);
        }
        if (TextUtils.isEmpty(this.wru.djK().ZdU)) {
          break label1628;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.wru.djK().ZdU))
      {
        localView = findViewById(a.d.weM);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.plc.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.c.l.alv(this.wru.djK().nRQ);
      this.plc.findViewById(a.d.wgh).setBackgroundColor(i);
      this.wry.setActionbarColor(i);
      break;
      label1140:
      if (this.wru.djq())
      {
        this.plc.findViewById(a.d.wkc).setBackgroundResource(0);
        localView.setBackgroundColor(this.wry.getResources().getColor(a.a.white));
        break label204;
      }
      if (this.wru.djs())
      {
        ((View)localObject2).setBackgroundResource(a.c.weA);
        this.plc.findViewById(a.d.wkc).setBackgroundResource(a.c.wem);
        localView.setBackgroundResource(0);
        break label204;
      }
      if ((this.wru.djt()) || (!this.wru.dju())) {
        break label204;
      }
      localView.setBackgroundColor(this.wry.getResources().getColor(a.a.white));
      break label204;
      label1274:
      if (this.wru.djp())
      {
        if ((this.wzM.dny()) && (this.wzO))
        {
          ((View)localObject2).setBackgroundResource(a.c.weA);
          localView.setBackgroundResource(0);
          break label204;
        }
        if ((this.wzM.dny()) && (!this.wzO))
        {
          ((View)localObject2).setBackgroundResource(a.c.wey);
          localView.setBackgroundResource(0);
          break label204;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.wzM.dmH())
        {
          localView.setBackgroundResource(a.c.wey);
          break label204;
        }
        localView.setBackgroundResource(a.c.weA);
        break label204;
      }
      if (this.wru.djr())
      {
        ((View)localObject2).setClipToOutline(true);
        ((View)localObject2).setOutlineProvider(new ViewOutlineProvider()
        {
          public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
          {
            AppMethodBeat.i(293782);
            paramAnonymousOutline.setRoundRect(0, 0, paramAnonymousView.getWidth(), paramAnonymousView.getHeight(), com.tencent.mm.cd.a.br(e.this.wry, a.b.Edge_0_5_A));
            AppMethodBeat.o(293782);
          }
        });
        localView.setBackgroundColor(this.wry.getResources().getColor(a.a.UN_BW_97));
        break label204;
      }
      if (this.wru.djs())
      {
        ((View)localObject2).setBackgroundResource(a.c.weC);
        localView.setBackgroundResource(0);
        break label204;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.wry.getResources().getColor(a.a.white));
      break label204;
      label1499:
      if ((this.wzR == null) || (((!this.wru.djo()) || (!this.wru.djr())) && (!this.wru.djp()))) {
        break label657;
      }
      if (this.wzM.dmH())
      {
        this.wzR.IO(a.c.weB);
        break label657;
      }
      this.wzR.IO(a.c.wez);
      break label657;
      label1584:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label823;
      label1599:
      i = this.wry.getResources().getDimensionPixelSize(a.b.BiggerPadding);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label939;
      label1628:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void dmx()
  {
    AppMethodBeat.i(113290);
    if (!this.wzM.dnC())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.wrz.clear();
    this.wrz.addAll(this.wAh.dkk());
    this.wzU.setData(this.wrz);
    this.wzU.wEN = this.wru.dju();
    this.wzU.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void dmy()
  {
    AppMethodBeat.i(113291);
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (dmz()) {
      dmB();
    }
    if (this.wzR == null) {
      dmA();
    }
    if (this.wzR != null)
    {
      if (this.wru.djs()) {
        ((com.tencent.mm.plugin.card.widget.f)this.wzR).wrB = this.wrB;
      }
      this.wzR.d(this.wru);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean dmz()
  {
    AppMethodBeat.i(113292);
    if (this.wzR == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.wru.djq())
    {
      if ((this.wzR instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.wru.djt())
    {
      if ((this.wzR instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.wru.djr())
    {
      if ((this.wzR instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.wru.djs())
    {
      if ((this.wzR instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.wru.dju())
    {
      if ((this.wzR instanceof com.tencent.mm.plugin.card.widget.d))
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
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, b paramb1, ArrayList<wl> paramArrayList)
  {
    AppMethodBeat.i(293872);
    this.wru = paramb;
    this.wAo = paramb1;
    this.wrB = paramArrayList;
    if ((this.wru != null) && (this.wru.djr())) {
      this.wzU.wEO = true;
    }
    AppMethodBeat.o(293872);
  }
  
  public final void a(boolean paramBoolean1, i.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.wru.djL().ZbG;
      if (this.wru.djC())
      {
        com.tencent.mm.plugin.card.c.b.a(this.wry, paramb.wso, paramb.wsp, paramBoolean2, this.wru);
        com.tencent.mm.plugin.report.service.h.OAn.b(11941, new Object[] { Integer.valueOf(17), this.wru.djO(), this.wru.djP(), "", this.wru.djL().ZbG.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aek)localObject1).Zdw)) && (!TextUtils.isEmpty(((aek)localObject1).Zdx)))
      {
        com.tencent.mm.plugin.card.c.b.a(this.wru.djO(), (aek)localObject1, this.wAo.wxa, this.wAo.wAu);
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        str1 = this.wru.djO();
        str2 = this.wru.djP();
        if (((aek)localObject1).title != null) {}
        for (paramb = ((aek)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((aek)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.c.l.ad(((aek)localObject1).url, ((aek)localObject1).ZeU);
        com.tencent.mm.plugin.card.c.b.a(this.wry, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.OAn;
        str1 = this.wru.djO();
        str2 = this.wru.djP();
        if (((aek)localObject1).title != null) {}
        for (paramb = ((aek)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).b(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      j = this.wru.djK().tNW;
      localObject2 = this.wru.djP();
      str1 = this.wru.djO();
      k = this.wAo.wxa;
      str2 = this.wAo.wzv;
      if (this.wru.djI()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        akY(paramb.wsl);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
    int k = this.wru.djK().tNW;
    Object localObject2 = this.wru.djP();
    String str1 = this.wru.djO();
    int m = this.wAo.wxa;
    String str2 = this.wAo.wzv;
    if (this.wru.djI()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).b(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      akY(paramb.wsl);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aY(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    Log.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    d locald = new d((byte)0);
    locald.wAA = c.wAy;
    locald.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(a.g.woD);
    }
    for (;;)
    {
      locald.errMsg = paramString;
      localMessage.obj = locald;
      this.wAp.sendMessage(localMessage);
      AppMethodBeat.o(113282);
      return;
      if (paramInt == 2) {
        paramString = getString(a.g.wom);
      } else {
        paramString = getString(a.g.woC);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113277);
    if (paramb != null)
    {
      this.wru = paramb;
      if (this.wAn != null) {
        this.wAn.b(paramb);
      }
      dlx();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(113284);
    Log.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    d locald = new d((byte)0);
    locald.wAA = c.wAx;
    locald.wAB = paramc;
    localMessage.obj = locald;
    this.wAp.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void c(com.tencent.mm.plugin.card.c.c paramc)
  {
    AppMethodBeat.i(113281);
    Log.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    d locald = new d((byte)0);
    locald.wAA = c.wAv;
    locald.wAB = paramc;
    localMessage.obj = locald;
    this.wAp.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final void dko()
  {
    AppMethodBeat.i(113283);
    Log.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    d locald = new d((byte)0);
    locald.wAA = c.wAw;
    localMessage.obj = locald;
    this.wAp.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final void dlx()
  {
    AppMethodBeat.i(113280);
    if (this.wru == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.wAn != null) {
        this.wAn.dmh();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.wru.djK() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.wAn != null) {
        this.wAn.dmh();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.wru.djL() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.wAn != null) {
        this.wAn.dmh();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.wru.djv())
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.wru.djK().tNW) });
      if (!TextUtils.isEmpty(this.wru.djK().ZdP))
      {
        com.tencent.mm.plugin.card.c.b.a(this.wry, this.wru.djK().ZdP, 0);
        if (this.wAn != null)
        {
          this.wAn.dmh();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.k.a(this.wry, getString(a.g.card_not_support_card_type), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.j(e.this) != null) {
              e.j(e.this).dmh();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.wru.djK().Zek);
    this.wAh.a(this.wru, this.wrB, this.wAo.lCR);
    dmu();
    this.wzM.dnP();
    Log.i("MicroMsg.CardDetailUIContoller", "");
    aMl();
    dmy();
    if (this.wzM.dny())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.wzN.update();
      if (!this.wzM.dno()) {
        break label1162;
      }
      if (this.wAe == null)
      {
        this.wAe = new com.tencent.mm.plugin.card.ui.view.b();
        this.wAe.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.wAe.update();
      label436:
      this.wry.showOptionMenu(this.wzM.dns());
      if (this.wzM.dnu()) {
        dmD();
      }
      if (this.wzM.dnv()) {
        dmE();
      }
      if (this.wzM.dnw()) {
        dmF();
      }
      this.wzM.dnt();
      P(this.wzM.dnq(), this.wzM.dnr());
      if ((this.wru.djq()) || (!this.wzM.dnA())) {
        break label1187;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.wzP.update();
      label571:
      if (this.wzR != null) {
        this.wzR.nl(this.wzM.dmH());
      }
      dmw();
      if (!this.wzM.dnF()) {
        break label1284;
      }
      if (this.wzW == null)
      {
        this.wzW = new y();
        this.wzW.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.wzW.update();
      label653:
      if (!this.wzM.dnO()) {
        break label1309;
      }
      if (this.wzV == null)
      {
        this.wzV = new com.tencent.mm.plugin.card.ui.view.c();
        this.wzV.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.wzV.update();
      label706:
      if (!this.wzM.dnG()) {
        break label1334;
      }
      if (this.wzX == null)
      {
        this.wzX = new com.tencent.mm.plugin.card.ui.view.k();
        this.wzX.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.wzX.update();
      label759:
      if (!this.wzM.dnH()) {
        break label1359;
      }
      if (this.wzY == null)
      {
        this.wzY = new w();
        this.wzY.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.wzY.update();
      label812:
      if (!this.wzM.dnI()) {
        break label1384;
      }
      if (this.wzZ == null)
      {
        this.wzZ = new com.tencent.mm.plugin.card.ui.view.l();
        this.wzZ.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.wzZ.update();
      label865:
      if (!this.wzM.dnJ()) {
        break label1409;
      }
      if (this.wAa == null)
      {
        this.wAa = new com.tencent.mm.plugin.card.ui.view.z();
        this.wAa.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.wAa.update();
      label918:
      if (!this.wzM.dnL()) {
        break label1434;
      }
      if (this.wAb == null)
      {
        this.wAb = new com.tencent.mm.plugin.card.ui.view.e();
        this.wAb.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.wAb.update();
      label971:
      if (!this.wzM.dnK()) {
        break label1459;
      }
      if (this.wAc == null)
      {
        this.wAc = new u();
        this.wAc.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.wAc.update();
      label1024:
      dmx();
      if (!this.wzM.dnD()) {
        break label1536;
      }
      dmC();
      if (!this.wzM.dnE()) {
        break label1519;
      }
      if (this.wzT != null) {
        break label1484;
      }
      dmv();
      this.wzT.a(this);
      this.wzT.update();
      label1082:
      if (this.wzR != null) {
        this.wzR.nk(true);
      }
      label1099:
      if (!this.wzM.dnM()) {
        break label1578;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.wAd.update();
    }
    for (;;)
    {
      this.wAf.wru = this.wru;
      AppMethodBeat.o(113280);
      return;
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.wzN.doE();
      break;
      label1162:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.wAe == null) {
        break label436;
      }
      this.wAe.doE();
      break label436;
      label1187:
      if ((this.wru.djq()) && (this.wzM.dnA()))
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.wzQ.update();
        break label571;
      }
      if (this.wzM.dnB())
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.wzQ.update();
        break label571;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.wzQ.doE();
      this.wzP.doE();
      break label571;
      label1284:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.wzW == null) {
        break label653;
      }
      this.wzW.doE();
      break label653;
      label1309:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.wzV == null) {
        break label706;
      }
      this.wzV.doE();
      break label706;
      label1334:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.wzX == null) {
        break label759;
      }
      this.wzX.doE();
      break label759;
      label1359:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.wzY == null) {
        break label812;
      }
      this.wzY.doE();
      break label812;
      label1384:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.wzZ == null) {
        break label865;
      }
      this.wzZ.doE();
      break label865;
      label1409:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.wAa == null) {
        break label918;
      }
      this.wAa.doE();
      break label918;
      label1434:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.wAb == null) {
        break label971;
      }
      this.wAb.doE();
      break label971;
      label1459:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.wAc == null) {
        break label1024;
      }
      this.wAc.doE();
      break label1024;
      label1484:
      if (!this.wzT.f(this.wru)) {
        break label1082;
      }
      this.wzT.b(this.wru);
      this.wzT.update();
      break label1082;
      label1519:
      if (this.wzT == null) {
        break label1082;
      }
      this.wzT.doI();
      break label1082;
      label1536:
      Log.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.wzT != null) {
        this.wzT.doI();
      }
      if (this.wzR == null) {
        break label1099;
      }
      this.wzR.nk(false);
      break label1099;
      label1578:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.wAd.doE();
    }
  }
  
  public final int dmG()
  {
    AppMethodBeat.i(113304);
    if (this.wAh == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.wAh.dkm())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean dmH()
  {
    AppMethodBeat.i(113305);
    if (this.wzM == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.wzM.dmH();
    AppMethodBeat.o(113305);
    return bool;
  }
  
  public final com.tencent.mm.plugin.card.base.b dmk()
  {
    return this.wru;
  }
  
  public final boolean dml()
  {
    return this.wzO;
  }
  
  public final void dmm()
  {
    this.wzO = false;
  }
  
  public final MMActivity dmn()
  {
    return this.wry;
  }
  
  public final View.OnClickListener dmo()
  {
    return this.qjL;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g dmp()
  {
    return this.wzM;
  }
  
  public final e dmq()
  {
    return this.wAn;
  }
  
  public final b dmr()
  {
    return this.wAo;
  }
  
  public final com.tencent.mm.plugin.card.mgr.e dms()
  {
    return this.wAh;
  }
  
  public final j dmt()
  {
    return this.wAf;
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.plc.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.wry.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public final void mmOnActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
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
        this.wAi = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.wAi;
        if ((this.wru == null) || (this.wru.djK() == null))
        {
          Log.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.wru.djM().abBp)) && (!this.wru.dju())) {
            localStringBuilder.append(this.wru.djM().abBp);
          }
        }
        for (;;)
        {
          String str = this.wru.djK().title + "\n" + this.wru.djK().mee;
          ac.a.Yde.a(this.wry.getController(), localStringBuilder.toString(), this.wru.djK().nQG, str, true, this.wry.getResources().getString(a.g.app_send), new y.a()
          {
            public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(293818);
              if (paramAnonymousBoolean)
              {
                e.this.wAj = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.j(e.this) != null) {
                    e.j(e.this).akX(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.b(e.this).djK().tNW), e.b(e.this).djP(), e.b(e.this).djO(), e.this.wAi });
                  com.tencent.mm.ui.base.k.cZ(e.c(e.this), e.c(e.this).getResources().getString(a.g.woN));
                  AppMethodBeat.o(293818);
                  return;
                }
                if (paramInt1 == 1)
                {
                  e.u(e.this);
                  com.tencent.mm.ui.base.k.cZ(e.c(e.this), e.c(e.this).getResources().getString(a.g.woN));
                  AppMethodBeat.o(293818);
                  return;
                }
                if (paramInt1 == 4)
                {
                  e.v(e.this);
                  com.tencent.mm.plugin.report.service.h.OAn.b(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.d(e.this).lCR), Integer.valueOf(e.b(e.this).djK().tNW), e.b(e.this).djP(), e.b(e.this).djO(), e.this.wAi });
                  com.tencent.mm.ui.base.k.cZ(e.c(e.this), e.c(e.this).getResources().getString(a.g.woN));
                }
              }
              AppMethodBeat.o(293818);
            }
          });
          AppMethodBeat.o(113301);
          return;
          localStringBuilder.append(getString(a.g.sns_post_to));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(a.g.wqj) + this.wAh.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(a.g.wpK) + this.wAh.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.wxB = paramIntent.getIntExtra("Ktag_range_index", 0);
        Log.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.wxB) });
        if (this.wxB >= 2)
        {
          this.wxC = paramIntent.getStringExtra("Klabel_name_list");
          this.wxD = paramIntent.getStringExtra("Kother_user_name_list");
          Log.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.wxB), this.wxC });
          if ((TextUtils.isEmpty(this.wxC)) && (TextUtils.isEmpty(this.wxD)))
          {
            Log.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.wxC.split(","));
          this.wxF = com.tencent.mm.plugin.card.c.l.eR(paramIntent);
          this.wxE = com.tencent.mm.plugin.card.c.l.eQ(paramIntent);
          if ((this.wxD != null) && (this.wxD.length() > 0))
          {
            paramIntent = Arrays.asList(this.wxD.split(","));
            this.wxE.addAll(paramIntent);
          }
          if (this.wxF != null) {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.wxF.size());
          }
          if (this.wxE != null)
          {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.wxE.size());
            paramIntent = this.wxE.iterator();
            while (paramIntent.hasNext()) {
              Log.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.wxB == 2)
          {
            this.wAd.all(this.wry.getString(a.g.wqb, new Object[] { dlz() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.wxB == 3)
          {
            this.wAd.all(this.wry.getString(a.g.wqa, new Object[] { dlz() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.wAd.all(this.wry.getString(a.g.wpZ));
          AppMethodBeat.o(113301);
          return;
        }
        this.wAd.all(this.wry.getString(a.g.wpZ));
        AppMethodBeat.o(113301);
        return;
        if (this.wAn != null) {
          this.wAn.dmj();
        }
      }
    }
  }
  
  static final class a
  {
    public String hPc;
    public String hzv;
    public String url;
    
    public a(bj parambj)
    {
      this.url = parambj.url;
      this.hzv = parambj.VcU;
      this.hPc = parambj.VcV;
    }
  }
  
  public static final class b
  {
    public int lCR = 3;
    public int wAu = 0;
    public String wrg = "";
    public boolean wsH = false;
    public int wxa = -1;
    public String wzc = "";
    public String wzd = "";
    public String wzv = "";
    public String wzw = "";
    public String wzx = "";
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(113274);
      wAv = new c("onGetCodeSuccess", 0);
      wAw = new c("onShowTimeExpired", 1);
      wAx = new c("onReceiveCodeUnavailable", 2);
      wAy = new c("onGetCodeFail", 3);
      wAz = new c[] { wAv, wAw, wAx, wAy };
      AppMethodBeat.o(113274);
    }
    
    private c() {}
  }
  
  static final class d
  {
    int errCode;
    String errMsg;
    e.c wAA;
    com.tencent.mm.plugin.card.c.c wAB;
  }
  
  public static abstract interface e
  {
    public abstract void akX(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void dmc();
    
    public abstract void dme();
    
    public abstract void dmf();
    
    public abstract void dmg();
    
    public abstract void dmh();
    
    public abstract void dmi();
    
    public abstract void dmj();
    
    public abstract void nd(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */