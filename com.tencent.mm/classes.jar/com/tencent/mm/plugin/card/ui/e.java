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
import com.tencent.mm.f.a.cq;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.b.j.b;
import com.tencent.mm.plugin.card.d.d.a;
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
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.r;
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
  boolean fEs;
  ListView mListView;
  private View mrI;
  View.OnClickListener nmC;
  com.tencent.mm.plugin.card.base.b tmU;
  MMActivity tmY;
  private List<com.tencent.mm.plugin.card.model.b> tmZ;
  private ArrayList<uu> tnb;
  public int tte;
  private String ttf;
  private String ttg;
  public ArrayList<String> tth;
  public ArrayList<String> tti;
  i tvA;
  i tvB;
  i tvC;
  i tvD;
  i tvE;
  com.tencent.mm.plugin.card.ui.view.d tvF;
  i tvG;
  j tvH;
  private boolean tvI;
  com.tencent.mm.plugin.card.b.f tvJ;
  public String tvK;
  public String tvL;
  private HashMap<Integer, String> tvM;
  private HashMap<String, String> tvN;
  private ArrayList<String> tvO;
  d tvP;
  private a tvQ;
  private MMHandler tvR;
  IListener tvS;
  com.tencent.mm.plugin.card.ui.a.g tvo;
  i tvp;
  private boolean tvq;
  i tvr;
  i tvs;
  com.tencent.mm.plugin.card.widget.g tvt;
  LinearLayout tvu;
  com.tencent.mm.plugin.card.ui.view.g tvv;
  m tvw;
  i tvx;
  i tvy;
  i tvz;
  
  public e(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(113275);
    this.TAG = "MicroMsg.CardDetailUIContoller";
    this.tvq = false;
    this.tvI = true;
    this.tmZ = new ArrayList();
    this.tvK = "";
    this.tvL = "";
    this.tte = 0;
    this.ttf = "";
    this.ttg = "";
    this.tth = new ArrayList();
    this.tti = new ArrayList();
    this.tvM = new HashMap();
    this.tvN = new HashMap();
    this.tvO = new ArrayList();
    this.fEs = false;
    this.tvR = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(113264);
        if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof e.c)))
        {
          paramAnonymousMessage = (e.c)paramAnonymousMessage.obj;
          if (paramAnonymousMessage.twc == e.b.twa)
          {
            if (e.k(e.this) != null)
            {
              com.tencent.mm.plugin.card.d.d.a(e.c(e.this), paramAnonymousMessage.errMsg, false);
              e.k(e.this).cLb();
              AppMethodBeat.o(113264);
            }
          }
          else if (paramAnonymousMessage.twc == e.b.tvY)
          {
            if (e.k(e.this) != null)
            {
              e.k(e.this).d(com.tencent.mm.plugin.card.d.c.tGL);
              AppMethodBeat.o(113264);
            }
          }
          else if (e.k(e.this) != null) {
            e.k(e.this).d(paramAnonymousMessage.twd);
          }
        }
        AppMethodBeat.o(113264);
      }
    };
    this.nmC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = true;
        AppMethodBeat.i(113265);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getId() == a.d.taZ) || (paramAnonymousView.getId() == a.d.duV)) {
          if (e.b(e.this).cFW()) {
            if (e.j(e.this) != null) {
              e.j(e.this).cIO();
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(113265);
          return;
          if ((e.b(e.this).cFX()) && (e.j(e.this) != null))
          {
            e.j(e.this).cIM();
            continue;
            if ((paramAnonymousView.getId() == a.d.tfF) || (paramAnonymousView.getId() == a.d.tay))
            {
              com.tencent.mm.plugin.card.d.b.am(e.c(e.this), e.d(e.this).tuY);
            }
            else if ((paramAnonymousView.getId() == a.d.tfi) || (paramAnonymousView.getId() == a.d.teZ))
            {
              if (paramAnonymousView.getId() == a.d.tfi)
              {
                e.a(e.this, false);
                label237:
                if ((e.k(e.this) instanceof q))
                {
                  localObject = ((q)e.k(e.this)).e(com.tencent.mm.plugin.card.d.c.tGN);
                  e.l(e.this).tzM = ((String)localObject);
                }
                localObject = e.l(e.this);
                bool = e.m(e.this);
                ((j)localObject).cJK();
                ((j)localObject).tvI = bool;
                if ((((j)localObject).nmy == null) || (((j)localObject).nmy.isShowing())) {
                  continue;
                }
                ((j)localObject).nmy.showAtLocation(paramAnonymousView.getRootView(), 17, 0, 0);
                ((j)localObject).nmy.setFocusable(true);
                ((j)localObject).nmy.setTouchable(true);
                ((j)localObject).nmy.setBackgroundDrawable(new ColorDrawable(16777215));
                ((j)localObject).nmy.setOutsideTouchable(true);
                if (!((j)localObject).tvI) {
                  break label786;
                }
                ((j)localObject).tzI.setOnClickListener(((j)localObject).nmC);
                paramAnonymousView = ((j)localObject).tzE;
                if (((j)localObject).tsr == null) {
                  break label698;
                }
                ((j)localObject).tzE = com.tencent.mm.plugin.card.d.l.W(((j)localObject).tsr);
                label437:
                ((j)localObject).tzI.setImageBitmap(((j)localObject).tzE);
                ((j)localObject).tzL.add(0, paramAnonymousView);
                ((j)localObject).recycleBmpList();
                ((j)localObject).nmA.setVisibility(8);
                ((j)localObject).tzH.setVisibility(0);
                paramAnonymousView = ((j)localObject).tmU.cGt().code;
                if ((((j)localObject).tmU.cGs().Sgt != null) && (((j)localObject).tmU.cGs().Sgt.Sti)) {
                  break label740;
                }
                if (Util.isNullOrNil(((j)localObject).tmU.cGt().SdR)) {
                  break label707;
                }
                paramAnonymousView = ((j)localObject).tmU.cGt().SdR;
                label566:
                if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                  break label760;
                }
                ((j)localObject).tzJ.setText(com.tencent.mm.plugin.card.d.n.arY(paramAnonymousView));
                if (!((j)localObject).tmU.cGg()) {
                  break label747;
                }
                ((j)localObject).tzJ.setVisibility(0);
                label616:
                if (Util.isNullOrNil(((j)localObject).tmU.cGs().mKL)) {
                  break label773;
                }
                ((j)localObject).tzK.setText(((j)localObject).tmU.cGs().mKL);
                ((j)localObject).tzK.setVisibility(0);
              }
              for (;;)
              {
                ((j)localObject).nmy.update();
                break;
                if (paramAnonymousView.getId() != a.d.teZ) {
                  break label237;
                }
                e.a(e.this, true);
                break label237;
                label698:
                ((j)localObject).tzE = null;
                break label437;
                label707:
                if (!((j)localObject).tmU.cGl()) {
                  break label566;
                }
                if (!Util.isNullOrNil(((j)localObject).tzM))
                {
                  paramAnonymousView = ((j)localObject).tzM;
                  break label566;
                }
                label740:
                paramAnonymousView = "";
                break label566;
                label747:
                ((j)localObject).tzJ.setVisibility(8);
                break label616;
                label760:
                ((j)localObject).tzJ.setVisibility(8);
                break label616;
                label773:
                ((j)localObject).tzK.setVisibility(8);
              }
              label786:
              ((j)localObject).nmz.setOnClickListener(((j)localObject).nmC);
              ((j)localObject).nmz.setImageBitmap(((j)localObject).nmx);
              paramAnonymousView = ((j)localObject).tmU.cGt().code;
              if ((((j)localObject).tmU.cGs().Sgt == null) || (!((j)localObject).tmU.cGs().Sgt.Sti)) {
                if (!Util.isNullOrNil(((j)localObject).tmU.cGt().SdR))
                {
                  paramAnonymousView = ((j)localObject).tmU.cGt().SdR;
                  label894:
                  if ((TextUtils.isEmpty(paramAnonymousView)) || (paramAnonymousView.length() > 40)) {
                    break label1068;
                  }
                  ((j)localObject).tzF.setText(com.tencent.mm.plugin.card.d.n.arY(paramAnonymousView));
                  if (!((j)localObject).tmU.cGg()) {
                    break label1055;
                  }
                  ((j)localObject).tzF.setVisibility(0);
                  label944:
                  if (TextUtils.isEmpty(((j)localObject).tmU.cGs().mKL)) {
                    break label1081;
                  }
                  ((j)localObject).tzG.setText(((j)localObject).tmU.cGs().mKL);
                  ((j)localObject).tzG.setVisibility(0);
                }
              }
              for (;;)
              {
                ((j)localObject).nmA.setVisibility(0);
                ((j)localObject).tzH.setVisibility(8);
                break;
                if (!((j)localObject).tmU.cGl()) {
                  break label894;
                }
                if (!Util.isNullOrNil(((j)localObject).tzM))
                {
                  paramAnonymousView = ((j)localObject).tzM;
                  break label894;
                }
                paramAnonymousView = "";
                break label894;
                label1055:
                ((j)localObject).tzF.setVisibility(8);
                break label944;
                label1068:
                ((j)localObject).tzF.setVisibility(8);
                break label944;
                label1081:
                ((j)localObject).tzG.setVisibility(8);
              }
            }
            else
            {
              int j;
              String str1;
              int k;
              String str2;
              int i;
              if ((paramAnonymousView.getId() == a.d.tbG) || (paramAnonymousView.getId() == a.d.tbB) || (paramAnonymousView.getId() == a.d.tbA) || (paramAnonymousView.getId() == a.d.tfp) || (paramAnonymousView.getId() == a.d.tbz))
              {
                if (paramAnonymousView.getId() == a.d.tbG)
                {
                  if (e.b(e.this).cFX())
                  {
                    paramAnonymousView = com.tencent.mm.plugin.report.service.h.IzE;
                    j = e.b(e.this).cGs().qJt;
                    localObject = e.b(e.this).cGx();
                    str1 = e.b(e.this).cGw();
                    k = e.d(e.this).tsD;
                    str2 = e.d(e.this).tuY;
                    if (e.b(e.this).cGq()) {}
                    for (i = 1;; i = 0)
                    {
                      paramAnonymousView.a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
                      if (e.j(e.this) == null) {
                        break;
                      }
                      e.j(e.this).lJ(true);
                      break;
                    }
                  }
                  paramAnonymousView = new j.b();
                  e.this.a(true, paramAnonymousView, false);
                }
                else
                {
                  if ((paramAnonymousView.getId() == a.d.tfp) && (e.b(e.this).cGs().Sgw))
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (e.b(e.this).cFX())
                  {
                    if (e.j(e.this) != null) {
                      e.j(e.this).lJ(false);
                    }
                  }
                  else
                  {
                    paramAnonymousView = new j.b();
                    e.this.a(false, paramAnonymousView, false);
                  }
                }
              }
              else if (paramAnonymousView.getId() == a.d.taE)
              {
                if (!TextUtils.isEmpty(e.b(e.this).cGs().Sga))
                {
                  com.tencent.mm.plugin.card.d.b.a(e.c(e.this), e.b(e.this).cGs().Sga, 3);
                  com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(13), e.b(e.this).cGw(), e.b(e.this).cGx(), "", e.b(e.this).cGs().SfZ });
                }
              }
              else if (paramAnonymousView.getId() == a.d.tdh)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(e.b(e.this).cGs().qJt), e.b(e.this).cGx(), e.b(e.this).cGw(), e.d(e.this).tuY });
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("KLabel_range_index", e.this.tte);
                paramAnonymousView.putExtra("Klabel_name_list", e.n(e.this));
                paramAnonymousView.putExtra("Kother_user_name_list", e.o(e.this));
                paramAnonymousView.putExtra("k_sns_label_ui_title", e.c(e.this).getString(a.g.tlD));
                paramAnonymousView.putExtra("k_sns_label_ui_style", 0);
                paramAnonymousView.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.by.c.b(e.c(e.this), "sns", ".ui.SnsLabelUI", paramAnonymousView, 2);
                e.c(e.this).mmSetOnActivityResultCallback(e.this);
              }
              else if (paramAnonymousView.getId() == a.d.tdq)
              {
                if (e.b(e.this).cGt().SdF != null)
                {
                  localObject = e.b(e.this).cGt().SdF;
                  i = ((Integer)paramAnonymousView.getTag()).intValue();
                  paramAnonymousView = (acg)((LinkedList)localObject).get(i);
                  if (com.tencent.mm.plugin.card.d.b.a(e.b(e.this).cGw(), paramAnonymousView, e.d(e.this).tsD, e.d(e.this).tvW))
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(19), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(e.HU(i)), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.b(e.this).cGw()))
                    {
                      com.tencent.mm.plugin.card.d.l.arW(e.b(e.this).cGw());
                      com.tencent.mm.plugin.card.d.b.b(e.c(e.this), e.b(e.this).cGs().jEi);
                    }
                  }
                }
              }
              else if (paramAnonymousView.getId() == a.d.tdr)
              {
                if (e.b(e.this).cGt().SdF != null)
                {
                  paramAnonymousView = (acg)e.b(e.this).cGt().SdF.get(0);
                  if (com.tencent.mm.plugin.card.d.b.a(e.b(e.this).cGw(), paramAnonymousView, e.d(e.this).tsD, e.d(e.this).tvW))
                  {
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(19), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                  }
                  else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(10), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                    if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.b(e.this).cGw()))
                    {
                      com.tencent.mm.plugin.card.d.l.arW(e.b(e.this).cGw());
                      com.tencent.mm.plugin.card.d.b.b(e.c(e.this), e.b(e.this).cGs().jEi);
                    }
                  }
                }
              }
              else if ((paramAnonymousView.getId() == a.d.tdJ) || (paramAnonymousView.getId() == a.d.tda))
              {
                if (e.b(e.this).cGt().SdM != null) {
                  if (e.b(e.this).cGj())
                  {
                    if (e.b(e.this).cFX())
                    {
                      if (e.j(e.this) != null) {
                        e.j(e.this).lJ(false);
                      }
                    }
                    else
                    {
                      paramAnonymousView = new j.b();
                      e.this.a(false, paramAnonymousView, false);
                    }
                  }
                  else if (e.b(e.this).cGk())
                  {
                    paramAnonymousView = new j.b();
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), paramAnonymousView.tnN, paramAnonymousView.tnO, false, e.b(e.this));
                  }
                  else
                  {
                    paramAnonymousView = e.b(e.this).cGt().SdM;
                    if (com.tencent.mm.plugin.card.d.b.a(e.b(e.this).cGw(), paramAnonymousView, e.d(e.this).tsD, e.d(e.this).tvW))
                    {
                      com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(20), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                    }
                    else if ((paramAnonymousView != null) && (!TextUtils.isEmpty(paramAnonymousView.url)))
                    {
                      localObject = com.tencent.mm.plugin.card.d.l.Z(paramAnonymousView.url, paramAnonymousView.SgR);
                      com.tencent.mm.plugin.card.d.b.a(e.c(e.this), (String)localObject, 1);
                      com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(9), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.title });
                      if (com.tencent.mm.plugin.card.d.l.a(paramAnonymousView, e.b(e.this).cGw()))
                      {
                        com.tencent.mm.plugin.card.d.l.arW(e.b(e.this).cGw());
                        com.tencent.mm.plugin.card.d.b.b(e.c(e.this), e.b(e.this).cGs().jEi);
                      }
                    }
                  }
                }
              }
              else
              {
                String str3;
                if ((paramAnonymousView.getId() == a.d.tbR) || (paramAnonymousView.getId() == a.d.tbb))
                {
                  paramAnonymousView = e.b(e.this).cGs().Sgg;
                  localObject = com.tencent.mm.plugin.report.service.h.IzE;
                  j = e.b(e.this).cGs().qJt;
                  str1 = e.b(e.this).cGx();
                  str2 = e.b(e.this).cGw();
                  k = e.d(e.this).tsD;
                  str3 = e.d(e.this).tuY;
                  if (e.b(e.this).cGq()) {}
                  for (i = 1;; i = 0)
                  {
                    ((com.tencent.mm.plugin.report.service.h)localObject).a(11324, new Object[] { "CardLeftRightIntroduceView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                    if ((paramAnonymousView == null) || (TextUtils.isEmpty(paramAnonymousView.url))) {
                      break label3183;
                    }
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), paramAnonymousView.url, 1);
                    break;
                  }
                  label3183:
                  localObject = new Intent();
                  if ((e.b(e.this) instanceof CardInfo)) {
                    ((Intent)localObject).putExtra("key_card_info_data", (CardInfo)e.b(e.this));
                  }
                  for (;;)
                  {
                    ((Intent)localObject).setClass(e.c(e.this), CardDetailPreference.class);
                    paramAnonymousView = e.c(e.this);
                    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
                    com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
                    com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                    if ((e.b(e.this) instanceof ShareCardInfo)) {
                      ((Intent)localObject).putExtra("key_card_info_data", (ShareCardInfo)e.b(e.this));
                    }
                  }
                }
                if (paramAnonymousView.getId() == a.d.tgN)
                {
                  if (com.tencent.mm.plugin.card.sharecard.a.b.arf(e.b(e.this).cGx()) <= 1)
                  {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  paramAnonymousView = e.this;
                  if (!e.p(e.this)) {}
                  for (;;)
                  {
                    e.b(paramAnonymousView, bool);
                    e.this.cIg();
                    break;
                    bool = false;
                  }
                }
                if (paramAnonymousView.getId() == a.d.tbf)
                {
                  if ((e.b(e.this).cGs().Sgc != null) && (!TextUtils.isEmpty(e.b(e.this).cGs().Sgc.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), e.b(e.this).cGs().Sgc.url, 3);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(3), e.b(e.this).cGw(), e.b(e.this).cGx(), "", e.b(e.this).cGs().Sgc.text });
                  }
                }
                else if (paramAnonymousView.getId() == a.d.taX)
                {
                  if ((e.b(e.this).cGs().Sgj != null) && (!Util.isNullOrNil(e.b(e.this).cGs().Sgj.url)))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), e.b(e.this).cGs().Sgj.url, 1);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(14), e.b(e.this).cGw(), e.b(e.this).cGx(), "", e.b(e.this).cGs().Sgj.text });
                  }
                }
                else if ((paramAnonymousView.getId() == a.d.tgS) || (paramAnonymousView.getId() == a.d.tgT))
                {
                  if (e.b(e.this).cGs().SfT > 0)
                  {
                    if ((e.f(e.this) == null) || (e.f(e.this).size() == 0))
                    {
                      Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(113265);
                      return;
                    }
                    paramAnonymousView = (uu)e.f(e.this).get(0);
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), paramAnonymousView.latitude, paramAnonymousView.longitude, paramAnonymousView.lLg);
                    localObject = com.tencent.mm.plugin.report.service.h.IzE;
                    j = e.b(e.this).cGs().qJt;
                    str1 = e.b(e.this).cGx();
                    str2 = e.b(e.this).cGw();
                    k = e.d(e.this).tsD;
                    str3 = e.d(e.this).tuY;
                    if (e.b(e.this).cGq()) {}
                    for (i = 1;; i = 0)
                    {
                      ((com.tencent.mm.plugin.report.service.h)localObject).a(11324, new Object[] { "UsedStoresView", Integer.valueOf(j), str1, str2, Integer.valueOf(0), Integer.valueOf(k), str3, Integer.valueOf(i), "" });
                      com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(5), e.b(e.this).cGw(), e.b(e.this).cGx(), "", paramAnonymousView.name });
                      break;
                    }
                  }
                }
                else if (paramAnonymousView.getId() == a.d.thf)
                {
                  if ((e.f(e.this) == null) || (e.f(e.this).size() == 0))
                  {
                    Log.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  localObject = (uu)e.f(e.this).get(0);
                  paramAnonymousView = (String)paramAnonymousView.getTag();
                  if ((!TextUtils.isEmpty(paramAnonymousView)) && (paramAnonymousView.equals(e.c(e.this).getString(a.g.tjL))))
                  {
                    e.e(e.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardDetailUIContoller$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(113265);
                    return;
                  }
                  if (!TextUtils.isEmpty(((uu)localObject).jump_url))
                  {
                    com.tencent.mm.plugin.card.d.b.a(e.c(e.this), ((uu)localObject).jump_url, 1);
                    com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(4), e.b(e.this).cGw(), e.b(e.this).cGx(), "", ((uu)localObject).name });
                  }
                }
                else if (paramAnonymousView.getId() == a.d.tha)
                {
                  e.e(e.this);
                }
              }
            }
          }
        }
      }
    };
    this.tvS = new IListener() {};
    this.tmY = paramMMActivity;
    this.mrI = paramView;
    AppMethodBeat.o(113275);
  }
  
  private void HT(int paramInt)
  {
    AppMethodBeat.i(113300);
    LinkedList localLinkedList = this.tmU.cGt().SdK;
    if (localLinkedList == null)
    {
      AppMethodBeat.o(113300);
      return;
    }
    this.tvN.clear();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < localLinkedList.size())
    {
      be localbe = (be)localLinkedList.get(paramInt);
      j = i;
      if (!Util.isNullOrNil(localbe.text))
      {
        j = i;
        if (!Util.isNullOrNil(localbe.url))
        {
          this.tvO.add(localbe.text);
          this.tvM.put(Integer.valueOf(i), localbe.text);
          this.tvN.put(localbe.text, localbe.url);
          j = i + 1;
        }
      }
      paramInt += 1;
      i = j;
    }
    AppMethodBeat.o(113300);
  }
  
  private void L(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(113288);
    if (this.tvt != null) {
      this.tvt.L(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(113288);
  }
  
  private void art(String paramString)
  {
    AppMethodBeat.i(113303);
    Intent localIntent = new Intent();
    if ((this.tmU instanceof CardInfo)) {
      localIntent.putExtra("key_card_info_data", (CardInfo)this.tmU);
    }
    for (;;)
    {
      localIntent.setClass(this.tmY, CardConsumeCodeUI.class);
      localIntent.putExtra("key_from_scene", this.tvQ.jaR);
      localIntent.putExtra("key_previous_scene", this.tvQ.tsD);
      localIntent.putExtra("key_mark_user", paramString);
      localIntent.putExtra("key_from_appbrand_type", this.tvQ.tvW);
      this.tmY.startActivityForResult(localIntent, 3);
      this.tmY.mmSetOnActivityResultCallback(this);
      AppMethodBeat.o(113303);
      return;
      if ((this.tmU instanceof ShareCardInfo)) {
        localIntent.putExtra("key_card_info_data", (ShareCardInfo)this.tmU);
      }
    }
  }
  
  private String cIi()
  {
    AppMethodBeat.i(113302);
    String str;
    if ((!TextUtils.isEmpty(this.ttf)) && (!TextUtils.isEmpty(this.ttg)))
    {
      str = this.ttf + "," + com.tencent.mm.plugin.card.d.l.arU(this.ttg);
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttf))
    {
      str = this.ttf;
      AppMethodBeat.o(113302);
      return str;
    }
    if (!TextUtils.isEmpty(this.ttg))
    {
      str = com.tencent.mm.plugin.card.d.l.arU(this.ttg);
      AppMethodBeat.o(113302);
      return str;
    }
    AppMethodBeat.o(113302);
    return "";
  }
  
  private void cJc()
  {
    AppMethodBeat.i(113279);
    int i;
    if (this.tvo == null)
    {
      i = 0;
      if (i != 0)
      {
        this.tvo.release();
        this.tvo = null;
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[] { Integer.valueOf(this.tmU.cGs().qJt) });
      }
      if (this.tvo == null)
      {
        Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[] { Integer.valueOf(this.tmU.cGs().qJt) });
        Log.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[] { Integer.valueOf(this.tmU.cGs().qJt) });
        if (!this.tmU.cFX()) {
          break label423;
        }
        this.tvo = new com.tencent.mm.plugin.card.ui.a.h(this.tmY);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[] { Integer.valueOf(this.tmU.cGs().qJt) });
      this.tvo.a(this.tmU, this.tvQ);
      AppMethodBeat.o(113279);
      return;
      if (this.tmU.cFX())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.h))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.tmU.cFY())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.e))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.tmU.cGb())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.b))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.tmU.cFZ())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.c))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.tmU.cGa())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.f))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if (this.tmU.cGc())
      {
        if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.d))
        {
          i = 0;
          break;
        }
        i = 1;
        break;
      }
      if ((this.tvo instanceof com.tencent.mm.plugin.card.ui.a.a))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label423:
      switch (this.tmU.cGs().qJt)
      {
      default: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.a(this.tmY);
        break;
      case 0: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.c(this.tmY);
        break;
      case 10: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.e(this.tmY);
        break;
      case 11: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.b(this.tmY);
        break;
      case 20: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.f(this.tmY);
        break;
      case 30: 
        this.tvo = new com.tencent.mm.plugin.card.ui.a.d(this.tmY);
      }
    }
  }
  
  private void cJd()
  {
    AppMethodBeat.i(113285);
    if ((this.tmU.cGs().Sgt != null) && (this.tmU.cGs().Sgt.Sti))
    {
      this.tvv = new com.tencent.mm.plugin.card.ui.view.m();
      am.cHI().a(this);
      AppMethodBeat.o(113285);
      return;
    }
    if (this.tmU.cGs().qJt == 10)
    {
      this.tvv = new q();
      AppMethodBeat.o(113285);
      return;
    }
    this.tvv = new com.tencent.mm.plugin.card.ui.view.j();
    AppMethodBeat.o(113285);
  }
  
  private void cJe()
  {
    AppMethodBeat.i(113286);
    if (this.fEs)
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
      AppMethodBeat.o(113286);
      return;
    }
    Object localObject2;
    Object localObject1;
    View localView;
    label197:
    Object localObject3;
    int i;
    if ((this.tmU.cFW()) && (this.tmU.cFY()))
    {
      this.mrI.findViewById(a.d.tbU).setBackgroundColor(this.tmY.getResources().getColor(a.a.white));
      this.tmY.setActionbarColor(this.tmY.getResources().getColor(a.a.white));
      localObject2 = this.mrI.findViewById(a.d.tfz);
      localObject1 = this.mrI.findViewById(a.d.header_view);
      localView = this.mrI.findViewById(a.d.tfy);
      if ((!this.tmU.cFW()) || (!this.tvo.cKk())) {
        break label1267;
      }
      if (!this.tmU.cFZ()) {
        break label1133;
      }
      ((View)localObject2).setBackgroundResource(a.c.tas);
      this.mrI.findViewById(a.d.tfG).setBackgroundResource(a.c.tae);
      localView.setBackgroundResource(0);
      Object localObject4;
      if (this.tmU.cGc())
      {
        localObject3 = (TextView)this.mrI.findViewById(a.d.taQ);
        localObject4 = new BitmapDrawable(BitmapUtil.getBitmapNative(a.c.tap));
        ((BitmapDrawable)localObject4).setTileModeX(Shader.TileMode.REPEAT);
        ((TextView)localObject3).setBackgroundDrawable((Drawable)localObject4);
        ((TextView)localObject3).setVisibility(0);
      }
      localObject3 = new Rect(0, 0, 0, 0);
      ((View)localObject2).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      ((View)localObject2).invalidate();
      localView.setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
      localView.invalidate();
      if ((this.tmU.cFX()) && (this.tvo.cKi()) && (this.tvq))
      {
        localObject4 = this.mrI.findViewById(a.d.tgK);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
      }
      if ((this.tmU.cFW()) && (this.tvo.cKk()))
      {
        localObject4 = this.mrI.findViewById(a.d.tfG);
        ((Rect)localObject3).left = this.tmY.getResources().getDimensionPixelOffset(a.b.LargePadding);
        ((Rect)localObject3).right = this.tmY.getResources().getDimensionPixelOffset(a.b.LargePadding);
        ((View)localObject4).setPadding(((Rect)localObject3).left, ((Rect)localObject3).top, ((Rect)localObject3).right, ((Rect)localObject3).bottom);
        ((View)localObject4).invalidate();
        if (this.tmU.cGa())
        {
          localObject3 = this.mrI.findViewById(a.d.tfH);
          localObject4 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
          i = this.tmY.getResources().getDimensionPixelSize(a.b.SmallPadding);
          ((LinearLayout.LayoutParams)localObject4).rightMargin = i;
          ((LinearLayout.LayoutParams)localObject4).leftMargin = i;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
      }
      if ((!this.tvo.cKk()) && (!this.tvo.cKi())) {
        break label1491;
      }
      if ((this.tvt != null) && (((this.tmU.cFW()) && (this.tmU.cFZ())) || (this.tmU.cFX()))) {
        this.tvt.Il(0);
      }
      label650:
      if ((this.tvt != null) && (this.tmU.cFW()) && (this.tmU.cFY()))
      {
        i = this.tmY.getResources().getDimensionPixelOffset(a.b.sZR);
        localObject3 = com.tencent.mm.plugin.card.d.l.fF(com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL), i);
        this.tvt.a((ShapeDrawable)localObject3);
      }
      if ((this.tmU.cFW()) && (this.tmU.cFY()))
      {
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        if (TextUtils.isEmpty(this.tmU.cGs().SfZ)) {
          break label1576;
        }
        ((LinearLayout.LayoutParams)localObject3).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject3).height = -2;
        label816:
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i = this.tmY.getResources().getDimensionPixelSize(a.b.MiddlePadding);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        if (!this.tmU.cFY()) {
          break label1591;
        }
        ((LinearLayout.LayoutParams)localObject2).topMargin = this.tmY.getResources().getDimensionPixelSize(a.b.ListPadding);
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = this.tmY.getResources().getDimensionPixelSize(a.b.LittlePadding);
        i = this.tmY.getResources().getDimensionPixelSize(a.b.LargerPadding);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = i;
        ((LinearLayout.LayoutParams)localObject2).leftMargin = i;
        label932:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
        ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
        if (this.tmU.cFY()) {
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = this.tmY.getResources().getDimensionPixelSize(a.b.LargerPadding);
        }
        if (TextUtils.isEmpty(this.tmU.cGs().SfZ)) {
          break label1620;
        }
        ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
        ((LinearLayout.LayoutParams)localObject1).height = -2;
      }
    }
    for (;;)
    {
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (!TextUtils.isEmpty(this.tmU.cGs().SfZ))
      {
        localView = findViewById(a.d.taD);
        localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = 0;
        ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      this.mrI.invalidate();
      AppMethodBeat.o(113286);
      return;
      i = com.tencent.mm.plugin.card.d.l.arR(this.tmU.cGs().lmL);
      this.mrI.findViewById(a.d.tbU).setBackgroundColor(i);
      this.tmY.setActionbarColor(i);
      break;
      label1133:
      if (this.tmU.cFY())
      {
        this.mrI.findViewById(a.d.tfG).setBackgroundResource(0);
        localView.setBackgroundColor(this.tmY.getResources().getColor(a.a.white));
        break label197;
      }
      if (this.tmU.cGa())
      {
        ((View)localObject2).setBackgroundResource(a.c.tas);
        this.mrI.findViewById(a.d.tfG).setBackgroundResource(a.c.tae);
        localView.setBackgroundResource(0);
        break label197;
      }
      if ((this.tmU.cGb()) || (!this.tmU.cGc())) {
        break label197;
      }
      localView.setBackgroundColor(this.tmY.getResources().getColor(a.a.white));
      break label197;
      label1267:
      if (this.tmU.cFX())
      {
        if ((this.tvo.cKi()) && (this.tvq))
        {
          ((View)localObject2).setBackgroundResource(a.c.tas);
          localView.setBackgroundResource(0);
          break label197;
        }
        if ((this.tvo.cKi()) && (!this.tvq))
        {
          ((View)localObject2).setBackgroundResource(a.c.taq);
          localView.setBackgroundResource(0);
          break label197;
        }
        ((View)localObject2).setBackgroundResource(0);
        if (this.tvo.cJq())
        {
          localView.setBackgroundResource(a.c.taq);
          break label197;
        }
        localView.setBackgroundResource(a.c.tas);
        break label197;
      }
      if (this.tmU.cFZ())
      {
        ((View)localObject2).setBackgroundResource(0);
        if (this.tvo.cJq())
        {
          localView.setBackgroundResource(a.c.taq);
          break label197;
        }
        localView.setBackgroundResource(a.c.tas);
        break label197;
      }
      if (this.tmU.cGa())
      {
        ((View)localObject2).setBackgroundResource(a.c.tau);
        localView.setBackgroundResource(0);
        break label197;
      }
      ((View)localObject2).setBackgroundResource(0);
      localView.setBackgroundColor(this.tmY.getResources().getColor(a.a.white));
      break label197;
      label1491:
      if ((this.tvt == null) || (((!this.tmU.cFW()) || (!this.tmU.cFZ())) && (!this.tmU.cFX()))) {
        break label650;
      }
      if (this.tvo.cJq())
      {
        this.tvt.Il(a.c.tat);
        break label650;
      }
      this.tvt.Il(a.c.tar);
      break label650;
      label1576:
      ((LinearLayout.LayoutParams)localObject3).height = 0;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      break label816;
      label1591:
      i = this.tmY.getResources().getDimensionPixelSize(a.b.BiggerPadding);
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = i;
      ((LinearLayout.LayoutParams)localObject2).topMargin = i;
      break label932;
      label1620:
      ((LinearLayout.LayoutParams)localObject1).height = 0;
      ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    }
  }
  
  private void cJf()
  {
    AppMethodBeat.i(113290);
    if (!this.tvo.cKm())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
      AppMethodBeat.o(113290);
      return;
    }
    this.tmZ.clear();
    this.tmZ.addAll(this.tvJ.cGT());
    this.tvw.setData(this.tmZ);
    this.tvw.tAr = this.tmU.cGc();
    this.tvw.notifyDataSetChanged();
    AppMethodBeat.o(113290);
  }
  
  private void cJg()
  {
    AppMethodBeat.i(113291);
    if (this.tmU == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
      AppMethodBeat.o(113291);
      return;
    }
    if (cJh()) {
      cJj();
    }
    if (this.tvt == null) {
      cJi();
    }
    if (this.tvt != null)
    {
      if (this.tmU.cGa()) {
        ((com.tencent.mm.plugin.card.widget.f)this.tvt).tnb = this.tnb;
      }
      this.tvt.d(this.tmU);
    }
    AppMethodBeat.o(113291);
  }
  
  private boolean cJh()
  {
    AppMethodBeat.i(113292);
    if (this.tvt == null)
    {
      AppMethodBeat.o(113292);
      return false;
    }
    if (this.tmU.cFY())
    {
      if ((this.tvt instanceof com.tencent.mm.plugin.card.widget.e))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.tmU.cGb())
    {
      if ((this.tvt instanceof com.tencent.mm.plugin.card.widget.c))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.tmU.cFZ())
    {
      if ((this.tvt instanceof com.tencent.mm.plugin.card.widget.b))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.tmU.cGa())
    {
      if ((this.tvt instanceof com.tencent.mm.plugin.card.widget.f))
      {
        AppMethodBeat.o(113292);
        return false;
      }
      AppMethodBeat.o(113292);
      return true;
    }
    if (this.tmU.cGc())
    {
      if ((this.tvt instanceof com.tencent.mm.plugin.card.widget.d))
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
  
  private void cJi()
  {
    AppMethodBeat.i(113293);
    if (this.tmU.cFY()) {
      this.tvt = new com.tencent.mm.plugin.card.widget.e(this.tmY);
    }
    for (;;)
    {
      this.tvt.i(this.tmU);
      View localView = this.tvt.eW();
      if (localView != null) {
        com.tencent.mm.plugin.card.d.n.a(localView, this.tvu);
      }
      this.tvu.invalidate();
      this.tvt.setOnClickListener(this.nmC);
      L(false, false);
      AppMethodBeat.o(113293);
      return;
      if (this.tmU.cGb()) {
        this.tvt = new com.tencent.mm.plugin.card.widget.c(this.tmY);
      } else if (this.tmU.cFZ()) {
        this.tvt = new com.tencent.mm.plugin.card.widget.b(this.tmY);
      } else if (this.tmU.cGa()) {
        this.tvt = new com.tencent.mm.plugin.card.widget.f(this.tmY);
      } else if (this.tmU.cGc()) {
        this.tvt = new com.tencent.mm.plugin.card.widget.d(this.tmY);
      } else {
        this.tvt = new com.tencent.mm.plugin.card.widget.b(this.tmY);
      }
    }
  }
  
  private void cJj()
  {
    AppMethodBeat.i(113294);
    View localView = this.tvt.eW();
    if (localView != null) {
      this.tvu.removeView(localView);
    }
    this.tvu.removeAllViews();
    this.tvu.invalidate();
    this.tvt.release();
    this.tvt = null;
    AppMethodBeat.o(113294);
  }
  
  private void cJk()
  {
    AppMethodBeat.i(113295);
    if ((this.tvt != null) && ((this.tvt instanceof com.tencent.mm.plugin.card.widget.b))) {
      ((com.tencent.mm.plugin.card.widget.b)this.tvt).cJk();
    }
    AppMethodBeat.o(113295);
  }
  
  private void cJl()
  {
    AppMethodBeat.i(113296);
    ua localua = this.tmU.cGt();
    this.tmU.a(localua);
    com.tencent.mm.plugin.card.d.l.h(this.tmU);
    AppMethodBeat.o(113296);
  }
  
  private void cJm()
  {
    int i = 0;
    AppMethodBeat.i(113297);
    this.tvM.clear();
    this.tvO.clear();
    if (this.tmU.cGf())
    {
      this.tvO.add(getString(a.g.tml));
      this.tvM.put(Integer.valueOf(0), "menu_func_share_friend");
      this.tvO.add(getString(a.g.tmk));
      this.tvM.put(Integer.valueOf(1), "menu_func_share_timeline");
      i = 2;
    }
    int j = i;
    if (!TextUtils.isEmpty(this.tmU.cGt().SdI))
    {
      this.tvO.add(getString(a.g.tle));
      this.tvM.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    HT(j);
    if (this.tvO.size() > 0) {
      this.tmY.showOptionMenu(true);
    }
    AppMethodBeat.o(113297);
  }
  
  private void cJn()
  {
    int j = 0;
    AppMethodBeat.i(113298);
    this.tvM.clear();
    this.tvO.clear();
    int i = j;
    if (this.tmU.cFW())
    {
      i = j;
      if (this.tmU.cGe())
      {
        if (Util.isNullOrNil(this.tmU.cGs().Sgz)) {
          break label235;
        }
        this.tvO.add(this.tmU.cGs().Sgz);
        this.tvM.put(Integer.valueOf(0), "menu_func_gift");
        i = 1;
      }
    }
    j = i;
    if (!TextUtils.isEmpty(this.tmU.cGt().SdI))
    {
      this.tvO.add(getString(a.g.tle));
      this.tvM.put(Integer.valueOf(i), "menu_func_report");
      j = i + 1;
    }
    if (this.tmU.cFW())
    {
      this.tvO.add(getString(a.g.app_delete));
      this.tvM.put(Integer.valueOf(j), "menu_func_delete");
      i = j + 1;
    }
    for (;;)
    {
      HT(i);
      if (this.tvO.size() > 0) {
        this.tmY.showOptionMenu(true);
      }
      AppMethodBeat.o(113298);
      return;
      label235:
      if (this.tmU.cGc())
      {
        this.tvO.add(getString(a.g.tld));
        break;
      }
      this.tvO.add(getString(a.g.tlc));
      break;
      i = j;
      if (this.tmU.cFX())
      {
        String str1 = com.tencent.mm.model.z.bcZ();
        String str2 = this.tmU.cGy();
        if ((str1 != null) && (str1.equals(str2)))
        {
          this.tvO.add(getString(a.g.app_delete));
          this.tvM.put(Integer.valueOf(j), "menu_func_delete_share_card");
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
  
  private void cJo()
  {
    int i = 0;
    AppMethodBeat.i(113299);
    this.tvM.clear();
    this.tvO.clear();
    if (!TextUtils.isEmpty(this.tmU.cGt().SdI))
    {
      this.tvO.add(getString(a.g.tle));
      this.tvM.put(Integer.valueOf(0), "menu_func_report");
      i = 1;
    }
    HT(i);
    if (this.tvO.size() > 0) {
      this.tmY.showOptionMenu(true);
    }
    AppMethodBeat.o(113299);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(113289);
    if (!this.tvo.cKh())
    {
      this.tmY.setMMTitle("");
      AppMethodBeat.o(113289);
      return;
    }
    this.tmY.setMMTitle(this.tvJ.getTitle());
    AppMethodBeat.o(113289);
  }
  
  public final void a(com.tencent.mm.plugin.card.base.b paramb, a parama, ArrayList<uu> paramArrayList)
  {
    this.tmU = paramb;
    this.tvQ = parama;
    this.tnb = paramArrayList;
  }
  
  public final void a(boolean paramBoolean1, j.b paramb, boolean paramBoolean2)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(113287);
    if (paramBoolean1)
    {
      localObject1 = this.tmU.cGt().SdM;
      if (this.tmU.cGk())
      {
        com.tencent.mm.plugin.card.d.b.a(this.tmY, paramb.tnN, paramb.tnO, paramBoolean2, this.tmU);
        com.tencent.mm.plugin.report.service.h.IzE.a(11941, new Object[] { Integer.valueOf(17), this.tmU.cGw(), this.tmU.cGx(), "", this.tmU.cGt().SdM.title });
        AppMethodBeat.o(113287);
        return;
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((acg)localObject1).SfB)) && (!TextUtils.isEmpty(((acg)localObject1).SfC)))
      {
        com.tencent.mm.plugin.card.d.b.a(this.tmU.cGw(), (acg)localObject1, this.tvQ.tsD, this.tvQ.tvW);
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        str1 = this.tmU.cGw();
        str2 = this.tmU.cGx();
        if (((acg)localObject1).title != null) {}
        for (paramb = ((acg)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(((acg)localObject1).url)))
      {
        paramb = com.tencent.mm.plugin.card.d.l.Z(((acg)localObject1).url, ((acg)localObject1).SgR);
        com.tencent.mm.plugin.card.d.b.a(this.tmY, paramb, 1);
        localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
        str1 = this.tmU.cGw();
        str2 = this.tmU.cGx();
        if (((acg)localObject1).title != null) {}
        for (paramb = ((acg)localObject1).title;; paramb = "")
        {
          ((com.tencent.mm.plugin.report.service.h)localObject2).a(11941, new Object[] { Integer.valueOf(6), str1, str2, "", paramb });
          AppMethodBeat.o(113287);
          return;
        }
      }
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      j = this.tmU.cGs().qJt;
      localObject2 = this.tmU.cGx();
      str1 = this.tmU.cGw();
      k = this.tvQ.tsD;
      str2 = this.tvQ.tuY;
      if (this.tmU.cGq()) {}
      for (;;)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(j), localObject2, str1, Integer.valueOf(0), Integer.valueOf(k), str2, Integer.valueOf(i), "" });
        art(paramb.tnK);
        AppMethodBeat.o(113287);
        return;
        i = 0;
      }
    }
    Object localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
    int k = this.tmU.cGs().qJt;
    Object localObject2 = this.tmU.cGx();
    String str1 = this.tmU.cGw();
    int m = this.tvQ.tsD;
    String str2 = this.tvQ.tuY;
    if (this.tmU.cGq()) {}
    for (i = j;; i = 0)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(11324, new Object[] { "CardConsumedCodeUI", Integer.valueOf(k), localObject2, str1, Integer.valueOf(0), Integer.valueOf(m), str2, Integer.valueOf(i), "" });
      art(paramb.tnK);
      AppMethodBeat.o(113287);
      return;
    }
  }
  
  public final void aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(113282);
    Log.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.twc = e.b.twa;
    localc.errCode = paramInt;
    if (paramInt == -1) {
      paramString = getString(a.g.tkf);
    }
    for (;;)
    {
      localc.errMsg = paramString;
      localMessage.obj = localc;
      this.tvR.sendMessage(localMessage);
      AppMethodBeat.o(113282);
      return;
      if (paramInt == 2) {
        paramString = getString(a.g.tjP);
      } else {
        paramString = getString(a.g.tke);
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.card.base.b paramb)
  {
    AppMethodBeat.i(113277);
    if (paramb != null)
    {
      this.tmU = paramb;
      if (this.tvP != null) {
        this.tvP.b(paramb);
      }
      cIg();
    }
    AppMethodBeat.o(113277);
  }
  
  public final void b(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113284);
    Log.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.twc = e.b.tvZ;
    localc.twd = paramc;
    localMessage.obj = localc;
    this.tvR.sendMessage(localMessage);
    AppMethodBeat.o(113284);
  }
  
  public final void c(com.tencent.mm.plugin.card.d.c paramc)
  {
    AppMethodBeat.i(113281);
    Log.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.twc = e.b.tvX;
    localc.twd = paramc;
    localMessage.obj = localc;
    this.tvR.sendMessage(localMessage);
    AppMethodBeat.o(113281);
  }
  
  public final void cGX()
  {
    AppMethodBeat.i(113283);
    Log.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
    Message localMessage = Message.obtain();
    c localc = new c((byte)0);
    localc.twc = e.b.tvY;
    localMessage.obj = localc;
    this.tvR.sendMessage(localMessage);
    AppMethodBeat.o(113283);
  }
  
  public final com.tencent.mm.plugin.card.base.b cIS()
  {
    return this.tmU;
  }
  
  public final boolean cIT()
  {
    return this.tvq;
  }
  
  public final void cIU()
  {
    this.tvq = false;
  }
  
  public final MMActivity cIV()
  {
    return this.tmY;
  }
  
  public final View.OnClickListener cIW()
  {
    return this.nmC;
  }
  
  public final com.tencent.mm.plugin.card.ui.a.g cIX()
  {
    return this.tvo;
  }
  
  public final d cIY()
  {
    return this.tvP;
  }
  
  public final a cIZ()
  {
    return this.tvQ;
  }
  
  public final void cIg()
  {
    AppMethodBeat.i(113280);
    if (this.tmU == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
      if (this.tvP != null) {
        this.tvP.cIP();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.tmU.cGs() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
      if (this.tvP != null) {
        this.tvP.cIP();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (this.tmU.cGt() == null)
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
      if (this.tvP != null) {
        this.tvP.cIP();
      }
      AppMethodBeat.o(113280);
      return;
    }
    if (!this.tmU.cGd())
    {
      Log.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[] { Integer.valueOf(this.tmU.cGs().qJt) });
      if (!TextUtils.isEmpty(this.tmU.cGs().SfU))
      {
        com.tencent.mm.plugin.card.d.b.a(this.tmY, this.tmU.cGs().SfU, 0);
        if (this.tvP != null)
        {
          this.tvP.cIP();
          AppMethodBeat.o(113280);
        }
      }
      else
      {
        com.tencent.mm.ui.base.h.a(this.tmY, getString(a.g.card_not_support_card_type), null, false, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(113263);
            paramAnonymousDialogInterface.dismiss();
            if (e.j(e.this) != null) {
              e.j(e.this).cIP();
            }
            AppMethodBeat.o(113263);
          }
        });
      }
      AppMethodBeat.o(113280);
      return;
    }
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
    Log.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.tmU.cGs().Sgp);
    this.tvJ.a(this.tmU, this.tnb, this.tvQ.jaR);
    cJc();
    this.tvo.cKz();
    Log.i("MicroMsg.CardDetailUIContoller", "");
    updateTitle();
    cJg();
    if (this.tvo.cKi())
    {
      Log.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
      this.tvp.update();
      if (!this.tvo.cJY()) {
        break label1166;
      }
      if (this.tvG == null)
      {
        this.tvG = new com.tencent.mm.plugin.card.ui.view.b();
        this.tvG.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
      this.tvG.update();
      label436:
      this.tmY.showOptionMenu(this.tvo.cKc());
      if (this.tvo.cKe()) {
        cJm();
      }
      if (this.tvo.cKf()) {
        cJn();
      }
      if (this.tvo.cKg()) {
        cJo();
      }
      this.tvo.cKd();
      cJk();
      L(this.tvo.cKa(), this.tvo.cKb());
      if ((this.tmU.cFY()) || (!this.tvo.cKk())) {
        break label1191;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
      this.tvr.update();
      label575:
      if (this.tvt != null) {
        this.tvt.lQ(this.tvo.cJq());
      }
      cJe();
      if (!this.tvo.cKp()) {
        break label1288;
      }
      if (this.tvy == null)
      {
        this.tvy = new y();
        this.tvy.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
      this.tvy.update();
      label657:
      if (!this.tvo.cKy()) {
        break label1313;
      }
      if (this.tvx == null)
      {
        this.tvx = new com.tencent.mm.plugin.card.ui.view.c();
        this.tvx.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
      this.tvx.update();
      label710:
      if (!this.tvo.cKq()) {
        break label1338;
      }
      if (this.tvz == null)
      {
        this.tvz = new k();
        this.tvz.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
      this.tvz.update();
      label763:
      if (!this.tvo.cKr()) {
        break label1363;
      }
      if (this.tvA == null)
      {
        this.tvA = new w();
        this.tvA.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
      this.tvA.update();
      label816:
      if (!this.tvo.cKs()) {
        break label1388;
      }
      if (this.tvB == null)
      {
        this.tvB = new com.tencent.mm.plugin.card.ui.view.l();
        this.tvB.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
      this.tvB.update();
      label869:
      if (!this.tvo.cKt()) {
        break label1413;
      }
      if (this.tvC == null)
      {
        this.tvC = new com.tencent.mm.plugin.card.ui.view.z();
        this.tvC.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
      this.tvC.update();
      label922:
      if (!this.tvo.cKv()) {
        break label1438;
      }
      if (this.tvD == null)
      {
        this.tvD = new com.tencent.mm.plugin.card.ui.view.e();
        this.tvD.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
      this.tvD.update();
      label975:
      if (!this.tvo.cKu()) {
        break label1463;
      }
      if (this.tvE == null)
      {
        this.tvE = new com.tencent.mm.plugin.card.ui.view.u();
        this.tvE.a(this);
      }
      Log.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
      this.tvE.update();
      label1028:
      cJf();
      if (!this.tvo.cKn()) {
        break label1540;
      }
      cJl();
      if (!this.tvo.cKo()) {
        break label1523;
      }
      if (this.tvv != null) {
        break label1488;
      }
      cJd();
      this.tvv.a(this);
      this.tvv.update();
      label1086:
      if (this.tvt != null) {
        this.tvt.lP(true);
      }
      label1103:
      if (!this.tvo.cKw()) {
        break label1582;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
      this.tvF.update();
    }
    for (;;)
    {
      this.tvH.tmU = this.tmU;
      AppMethodBeat.o(113280);
      return;
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
      this.tvp.cKY();
      break;
      label1166:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
      if (this.tvG == null) {
        break label436;
      }
      this.tvG.cKY();
      break label436;
      label1191:
      if ((this.tmU.cFY()) && (this.tvo.cKk()))
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
        this.tvs.update();
        break label575;
      }
      if (this.tvo.cKl())
      {
        Log.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
        this.tvs.update();
        break label575;
      }
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
      this.tvs.cKY();
      this.tvr.cKY();
      break label575;
      label1288:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
      if (this.tvy == null) {
        break label657;
      }
      this.tvy.cKY();
      break label657;
      label1313:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
      if (this.tvx == null) {
        break label710;
      }
      this.tvx.cKY();
      break label710;
      label1338:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
      if (this.tvz == null) {
        break label763;
      }
      this.tvz.cKY();
      break label763;
      label1363:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
      if (this.tvA == null) {
        break label816;
      }
      this.tvA.cKY();
      break label816;
      label1388:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
      if (this.tvB == null) {
        break label869;
      }
      this.tvB.cKY();
      break label869;
      label1413:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
      if (this.tvC == null) {
        break label922;
      }
      this.tvC.cKY();
      break label922;
      label1438:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
      if (this.tvD == null) {
        break label975;
      }
      this.tvD.cKY();
      break label975;
      label1463:
      Log.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
      if (this.tvE == null) {
        break label1028;
      }
      this.tvE.cKY();
      break label1028;
      label1488:
      if (!this.tvv.f(this.tmU)) {
        break label1086;
      }
      this.tvv.b(this.tmU);
      this.tvv.update();
      break label1086;
      label1523:
      if (this.tvv == null) {
        break label1086;
      }
      this.tvv.cLc();
      break label1086;
      label1540:
      Log.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
      if (this.tvv != null) {
        this.tvv.cLc();
      }
      if (this.tvt == null) {
        break label1103;
      }
      this.tvt.lP(false);
      break label1103;
      label1582:
      Log.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
      this.tvF.cKY();
    }
  }
  
  public final com.tencent.mm.plugin.card.b.f cJa()
  {
    return this.tvJ;
  }
  
  public final j cJb()
  {
    return this.tvH;
  }
  
  public final int cJp()
  {
    AppMethodBeat.i(113304);
    if (this.tvJ == null)
    {
      AppMethodBeat.o(113304);
      return 0;
    }
    if (this.tvJ.cGV())
    {
      AppMethodBeat.o(113304);
      return 1;
    }
    AppMethodBeat.o(113304);
    return 0;
  }
  
  public final boolean cJq()
  {
    AppMethodBeat.i(113305);
    if (this.tvo == null)
    {
      AppMethodBeat.o(113305);
      return false;
    }
    boolean bool = this.tvo.cJq();
    AppMethodBeat.o(113305);
    return bool;
  }
  
  public final void d(final int paramInt1, int paramInt2, final Intent paramIntent)
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
        this.tvK = paramIntent.getStringExtra("Select_Conv_User");
        paramIntent = this.tvK;
        if ((this.tmU == null) || (this.tmU.cGs() == null))
        {
          Log.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
          AppMethodBeat.o(113301);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt1 == 0) {
          if ((!TextUtils.isEmpty(this.tmU.cGu().UjL)) && (!this.tmU.cGc())) {
            localStringBuilder.append(this.tmU.cGu().UjL);
          }
        }
        for (;;)
        {
          String str = this.tmU.cGs().title + "\n" + this.tmU.cGs().jEi;
          ab.a.RgY.a(this.tmY.getController(), localStringBuilder.toString(), this.tmU.cGs().llI, str, true, this.tmY.getResources().getString(a.g.app_send), new y.a()
          {
            public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(113270);
              if (paramAnonymousBoolean)
              {
                e.this.tvL = paramAnonymousString;
                if (paramInt1 == 0)
                {
                  if (e.j(e.this) != null) {
                    e.j(e.this).ars(paramIntent);
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(e.b(e.this).cGs().qJt), e.b(e.this).cGx(), e.b(e.this).cGw(), e.this.tvK });
                  com.tencent.mm.ui.base.h.cO(e.c(e.this), e.c(e.this).getResources().getString(a.g.tkp));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 1)
                {
                  e.u(e.this);
                  com.tencent.mm.ui.base.h.cO(e.c(e.this), e.c(e.this).getResources().getString(a.g.tkp));
                  AppMethodBeat.o(113270);
                  return;
                }
                if (paramInt1 == 4)
                {
                  e.v(e.this);
                  com.tencent.mm.plugin.report.service.h.IzE.a(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(e.d(e.this).jaR), Integer.valueOf(e.b(e.this).cGs().qJt), e.b(e.this).cGx(), e.b(e.this).cGw(), e.this.tvK });
                  com.tencent.mm.ui.base.h.cO(e.c(e.this), e.c(e.this).getResources().getString(a.g.tkp));
                }
              }
              AppMethodBeat.o(113270);
            }
          });
          AppMethodBeat.o(113301);
          return;
          localStringBuilder.append(getString(a.g.sns_post_to));
          continue;
          if (paramInt1 == 1) {
            localStringBuilder.append(getString(a.g.tlK) + this.tvJ.getTitle());
          } else if (paramInt1 == 4) {
            localStringBuilder.append(getString(a.g.tll) + this.tvJ.getTitle());
          }
        }
        if (paramInt2 != -1)
        {
          AppMethodBeat.o(113301);
          return;
        }
        this.tte = paramIntent.getIntExtra("Ktag_range_index", 0);
        Log.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[] { Integer.valueOf(this.tte) });
        if (this.tte >= 2)
        {
          this.ttf = paramIntent.getStringExtra("Klabel_name_list");
          this.ttg = paramIntent.getStringExtra("Kother_user_name_list");
          Log.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[] { Integer.valueOf(this.tte), this.ttf });
          if ((TextUtils.isEmpty(this.ttf)) && (TextUtils.isEmpty(this.ttg)))
          {
            Log.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
            AppMethodBeat.o(113301);
            return;
          }
          paramIntent = Arrays.asList(this.ttf.split(","));
          this.tti = com.tencent.mm.plugin.card.d.l.cW(paramIntent);
          this.tth = com.tencent.mm.plugin.card.d.l.cV(paramIntent);
          if ((this.ttg != null) && (this.ttg.length() > 0))
          {
            paramIntent = Arrays.asList(this.ttg.split(","));
            this.tth.addAll(paramIntent);
          }
          if (this.tti != null) {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.tti.size());
          }
          if (this.tth != null)
          {
            Log.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.tth.size());
            paramIntent = this.tth.iterator();
            while (paramIntent.hasNext()) {
              Log.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[] { (String)paramIntent.next() });
            }
          }
          if (this.tte == 2)
          {
            this.tvF.arH(this.tmY.getString(a.g.tlC, new Object[] { cIi() }));
            AppMethodBeat.o(113301);
            return;
          }
          if (this.tte == 3)
          {
            this.tvF.arH(this.tmY.getString(a.g.tlB, new Object[] { cIi() }));
            AppMethodBeat.o(113301);
            return;
          }
          this.tvF.arH(this.tmY.getString(a.g.tlA));
          AppMethodBeat.o(113301);
          return;
        }
        this.tvF.arH(this.tmY.getString(a.g.tlA));
        AppMethodBeat.o(113301);
        return;
        if (this.tvP != null) {
          this.tvP.cIR();
        }
      }
    }
  }
  
  public final View findViewById(int paramInt)
  {
    AppMethodBeat.i(113276);
    View localView = this.mrI.findViewById(paramInt);
    AppMethodBeat.o(113276);
    return localView;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(113278);
    String str = this.tmY.getString(paramInt);
    AppMethodBeat.o(113278);
    return str;
  }
  
  public static final class a
  {
    public int jaR = 3;
    public String tmG = "";
    public boolean tog = false;
    public int tsD = -1;
    public String tuF = "";
    public String tuG = "";
    public String tuY = "";
    public String tuZ = "";
    public int tvW = 0;
    public String tva = "";
  }
  
  static final class c
  {
    int errCode;
    String errMsg;
    e.b twc;
    com.tencent.mm.plugin.card.d.c twd;
  }
  
  public static abstract interface d
  {
    public abstract void ars(String paramString);
    
    public abstract void b(com.tencent.mm.plugin.card.base.b paramb);
    
    public abstract void cIL();
    
    public abstract void cIM();
    
    public abstract void cIN();
    
    public abstract void cIO();
    
    public abstract void cIP();
    
    public abstract void cIQ();
    
    public abstract void cIR();
    
    public abstract void lJ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e
 * JD-Core Version:    0.7.0.1
 */