package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.model.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends x<com.tencent.mm.plugin.masssend.model.a>
{
  private static short KNG = 1;
  private static short KNH = 2;
  private static short KNI = 3;
  private static short KNJ = 4;
  private short[] KNK;
  private List<String> KNL;
  String KNM;
  e KNN;
  int lNX;
  private MMActivity lzt;
  private LayoutInflater pUI;
  int wDI;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.model.a());
    AppMethodBeat.i(26409);
    this.KNM = "";
    this.lzt = ((MMActivity)paramContext);
    this.KNL = new LinkedList();
    this.wDI = 10;
    this.lNX = this.wDI;
    this.pUI = af.mU(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int aaq(int paramInt)
  {
    if (paramInt <= 2) {
      return 100;
    }
    if (paramInt < 10) {
      return (paramInt - 2) * 8 + 100;
    }
    if (paramInt < 60) {
      return (paramInt / 10 + 7) * 8 + 100;
    }
    return 204;
  }
  
  private void gah()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.KNK = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void aKW(String paramString)
  {
    AppMethodBeat.i(26413);
    this.KNM = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(26411);
    this.lNX = g.fZV().fZQ();
    w(g.fZV().Zj(this.wDI));
    gah();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(26410);
    aNy();
    AppMethodBeat.o(26410);
  }
  
  public final boolean dmY()
  {
    return this.wDI >= this.lNX;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26412);
    Object localObject1 = (com.tencent.mm.plugin.masssend.model.a)getItem(paramInt);
    int i;
    int j;
    label82:
    label102:
    label126:
    Object localObject2;
    if (paramInt != 0)
    {
      long l1 = ((com.tencent.mm.plugin.masssend.model.a)getItem(paramInt - 1)).createTime;
      paramViewGroup = (com.tencent.mm.plugin.masssend.model.a)getItem(paramInt);
      long l2 = paramViewGroup.createTime;
      if (l2 - l1 < 60000L)
      {
        i = 1;
        if ((l2 - l1) / 180000L >= 1L) {
          break label502;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label508;
        }
        this.KNK[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.KNK[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.model.a)localObject1).createTime <= 1000L)) {
          break label531;
        }
        paramInt = 1;
        switch (((com.tencent.mm.plugin.masssend.model.a)localObject1).msgType)
        {
        default: 
          paramViewGroup = paramView;
          label174:
          paramView = (f)paramViewGroup.getTag();
          label260:
          if (paramInt != 0)
          {
            paramView.vLJ.setVisibility(0);
            paramView.vLJ.setText(f.d(this.lzt, ((com.tencent.mm.plugin.masssend.model.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.model.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).KNP.setText(this.lzt.getResources().getQuantityString(R.j.gpn, ((com.tencent.mm.plugin.masssend.model.a)localObject1).KNi, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.model.a)localObject1).KNi) }));
              if (this.KNL.contains(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM()))
              {
                ((f)localObject2).KNQ.setSingleLine(false);
                ((f)localObject2).KNQ.setEllipsize(null);
              }
              break;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      Object localObject3 = ((f)localObject2).KNQ;
      MMActivity localMMActivity = this.lzt;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.model.a)localObject1).fZP() != null) && (!((com.tencent.mm.plugin.masssend.model.a)localObject1).fZP().equals(""))) {
        break label1756;
      }
      paramView = "";
      ((TextView)localObject3).setText(p.b(localMMActivity, paramView, ((f)localObject2).KNQ.getTextSize()));
      paramInt = (int)((f)localObject2).KNQ.getTextSize();
      paramView = ((f)localObject2).KNQ.getText().toString();
      com.tencent.mm.cd.a.fromDPToPix(this.lzt, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).KNT.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label502:
      j = 0;
      break label82;
      label508:
      this.KNK[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.KNK[paramInt] = 1;
      break label102;
      label531:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).KNW == KNG) {
          break label174;
        }
      }
      paramViewGroup = this.pUI.inflate(R.i.glw, null);
      ((f)localObject2).KNP = ((TextView)paramViewGroup.findViewById(R.h.fNJ));
      ((f)localObject2).KNQ = ((TextView)paramViewGroup.findViewById(R.h.fNL));
      ((f)localObject2).KNR = ((TextView)paramViewGroup.findViewById(R.h.fNM));
      ((f)localObject2).KNT = ((TextView)paramViewGroup.findViewById(R.h.fNH));
      ((f)localObject2).vLJ = ((TextView)paramViewGroup.findViewById(R.h.fNR));
      ((f)localObject2).KNV = paramViewGroup.findViewById(R.h.fNI);
      ((f)localObject2).KNW = KNG;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).KNW == KNJ) {
          break label174;
        }
      }
      paramViewGroup = this.pUI.inflate(R.i.gly, null);
      ((f)localObject2).KNP = ((TextView)paramViewGroup.findViewById(R.h.fNJ));
      ((f)localObject2).KNQ = ((TextView)paramViewGroup.findViewById(R.h.fNL));
      ((f)localObject2).KNS = ((TextView)paramViewGroup.findViewById(R.h.fNK));
      ((f)localObject2).KNR = ((TextView)paramViewGroup.findViewById(R.h.fNQ));
      ((f)localObject2).KNU = ((AnimImageView)paramViewGroup.findViewById(R.h.fNP));
      ((f)localObject2).KNT = ((TextView)paramViewGroup.findViewById(R.h.fNH));
      ((f)localObject2).vLJ = ((TextView)paramViewGroup.findViewById(R.h.fNR));
      ((f)localObject2).KNV = paramViewGroup.findViewById(R.h.fNI);
      ((f)localObject2).KNW = KNJ;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).KNW == KNH) {
          break label174;
        }
      }
      paramViewGroup = this.pUI.inflate(R.i.glv, null);
      ((f)localObject2).KNP = ((TextView)paramViewGroup.findViewById(R.h.fNJ));
      ((f)localObject2).KNQ = ((TextView)paramViewGroup.findViewById(R.h.fNL));
      ((f)localObject2).sIV = ((ImageView)paramViewGroup.findViewById(R.h.fNN));
      ((f)localObject2).KNT = ((TextView)paramViewGroup.findViewById(R.h.fNH));
      ((f)localObject2).vLJ = ((TextView)paramViewGroup.findViewById(R.h.fNR));
      ((f)localObject2).KNV = paramViewGroup.findViewById(R.h.fNI);
      ((f)localObject2).KNW = KNH;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).KNW == KNI) {
          break label174;
        }
      }
      paramViewGroup = this.pUI.inflate(R.i.glx, null);
      ((f)localObject2).KNP = ((TextView)paramViewGroup.findViewById(R.h.fNJ));
      ((f)localObject2).KNQ = ((TextView)paramViewGroup.findViewById(R.h.fNL));
      ((f)localObject2).sIV = ((ImageView)paramViewGroup.findViewById(R.h.fNN));
      ((f)localObject2).KNS = ((TextView)paramViewGroup.findViewById(R.h.fNO));
      ((f)localObject2).KNT = ((TextView)paramViewGroup.findViewById(R.h.fNH));
      ((f)localObject2).vLJ = ((TextView)paramViewGroup.findViewById(R.h.fNR));
      ((f)localObject2).KNV = paramViewGroup.findViewById(R.h.fNI);
      ((f)localObject2).KNW = KNI;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.vLJ.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.KNR.setText(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZN());
      p.t(paramView.KNR, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = s.jh(((com.tencent.mm.plugin.masssend.model.a)localObject1).KNj);
      if (((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM().equals(this.KNM))
      {
        paramView.KNU.setVisibility(0);
        paramView.KNU.cKI();
        paramView.KNR.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.KNS.setText(this.lzt.getString(R.l.gIM, new Object[] { Integer.valueOf((int)f) }));
        paramView.KNR.setWidth(com.tencent.mm.cd.a.fromDPToPix(paramView.KNR.getContext(), aaq((int)f)));
        paramView.KNU.setWidth(com.tencent.mm.cd.a.fromDPToPix(paramView.KNR.getContext(), aaq((int)f)));
        paramView.KNR.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZM()));
        break;
        paramView.KNU.setVisibility(8);
        paramView.KNU.dxz();
        paramView.KNR.setCompoundDrawablesWithIntrinsicBounds(null, null, this.lzt.getResources().getDrawable(R.k.chatto_voice_playing), null);
      }
      paramView = (f)paramViewGroup.getTag();
      bh.bCz();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        g.fZV();
        localObject2 = com.tencent.mm.plugin.masssend.model.b.aKR(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZN());
        if (localObject2 != null) {
          paramView.sIV.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.sIV.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZN(), ((com.tencent.mm.plugin.masssend.model.a)localObject1).KNm));
        break;
        g.fZV();
        localObject2 = com.tencent.mm.plugin.masssend.model.b.j(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZO(), com.tencent.mm.cd.a.getDensity(paramView.sIV.getContext()));
        paramView.sIV.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.sIV.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.g.nosdcard_chatting_bg));
      }
      paramView = (f)paramViewGroup.getTag();
      v.bOh();
      localObject2 = com.tencent.mm.modelvideo.aa.PY(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZN());
      localObject2 = r.bKa().a((String)localObject2, com.tencent.mm.cd.a.getDensity(paramView.sIV.getContext()), -1);
      if (localObject2 == null)
      {
        bh.bCz();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.sIV.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.k.video_no_sd_icon));
        }
      }
      for (;;)
      {
        paramView.sIV.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.model.a)localObject1).fZN(), ((com.tencent.mm.plugin.masssend.model.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.model.a)localObject1).heo, ((com.tencent.mm.plugin.masssend.model.a)localObject1).KNj));
        if (((com.tencent.mm.plugin.masssend.model.a)localObject1).videoSource != 2) {
          break label1707;
        }
        paramView.KNS.setVisibility(8);
        break;
        paramView.sIV.setImageDrawable(com.tencent.mm.cd.a.m(this.lzt, R.e.grey_color_01));
        continue;
        paramView.sIV.setImageBitmap((Bitmap)localObject2);
      }
      label1707:
      paramView.KNS.setVisibility(0);
      paramView.KNS.setText(Util.formatSecToMin(((com.tencent.mm.plugin.masssend.model.a)localObject1).KNj));
      break label260;
      ((f)localObject2).KNQ.setSingleLine(true);
      ((f)localObject2).KNQ.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1756:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.model.a)localObject1).fZP().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = Util.stringsToList((String[])localObject4);
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramView = "";
        break;
      }
      localObject4 = new StringBuilder();
      paramInt = 0;
      if (paramInt < paramView.size())
      {
        String str = com.tencent.mm.model.aa.getDisplayName((String)paramView.get(paramInt));
        if (paramInt == paramView.size() - 1) {
          ((StringBuilder)localObject4).append(str);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          ((StringBuilder)localObject4).append(str + ", ");
        }
      }
      paramView = ((StringBuilder)localObject4).toString();
      break;
    }
  }
  
  final class a
    implements View.OnClickListener
  {
    private int KNm;
    private String fileName;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.KNm = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      Log.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      bh.bCz();
      paramView = com.tencent.mm.model.c.bzL() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!com.tencent.mm.vfs.y.ZC(paramView)))
      {
        Log.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_compress_type", this.KNm);
      ((Intent)localObject).putExtra("key_favorite", false);
      ((Intent)localObject).putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.dNP().d(c.a(c.this), (Intent)localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26405);
    }
  }
  
  final class b
    implements View.OnClickListener
  {
    private String id;
    
    public b(String paramString)
    {
      this.id = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26406);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      localObject = g.fZV().aKS(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.model.a)localObject).fZP());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26406);
    }
  }
  
  final class c
    implements View.OnClickListener
  {
    private String fileName;
    private int length;
    private int size;
    private int videoSource;
    
    public c(String paramString, int paramInt1, int paramInt2, int paramInt3)
    {
      this.fileName = paramString;
      this.videoSource = paramInt1;
      this.length = paramInt3;
      this.size = paramInt2;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26407);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.aa.j(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26407);
        return;
      }
      if (this.videoSource == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        v.bOh();
        boolean bool2 = com.tencent.mm.modelvideo.y.PK(com.tencent.mm.modelvideo.aa.PX(this.fileName));
        Log.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.pFn.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26407);
        return;
      }
    }
  }
  
  final class d
    implements View.OnClickListener
  {
    private String id;
    
    public d(String paramString)
    {
      this.id = paramString;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26408);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      Log.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).aKX(this.id));
        c.this.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String aKX(String paramString);
  }
  
  static final class f
  {
    TextView KNP;
    TextView KNQ;
    TextView KNR;
    TextView KNS;
    TextView KNT;
    AnimImageView KNU;
    View KNV;
    short KNW;
    ImageView sIV;
    TextView vLJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */