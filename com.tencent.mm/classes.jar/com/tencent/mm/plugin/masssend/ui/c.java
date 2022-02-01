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
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.v<com.tencent.mm.plugin.masssend.a.a>
{
  private static short ETc = 1;
  private static short ETd = 2;
  private static short ETe = 3;
  private static short ETf = 4;
  private short[] ETg;
  private List<String> ETh;
  String ETi;
  e ETj;
  private MMActivity iXq;
  int jlf;
  private LayoutInflater mYa;
  int tzm;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.ETi = "";
    this.iXq = ((MMActivity)paramContext);
    this.ETh = new LinkedList();
    this.tzm = 10;
    this.jlf = this.tzm;
    this.mYa = ad.kS(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int Wu(int paramInt)
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
  
  private void eRy()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.ETg = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void aNZ(String paramString)
  {
    AppMethodBeat.i(26413);
    this.ETi = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(26411);
    this.jlf = h.eRm().eRh();
    v(h.eRm().Vo(this.tzm));
    eRy();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(26410);
    atr();
    AppMethodBeat.o(26410);
  }
  
  public final boolean cJI()
  {
    return this.tzm >= this.jlf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(26412);
    Object localObject1 = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
    int i;
    int j;
    label82:
    label102:
    label126:
    Object localObject2;
    if (paramInt != 0)
    {
      long l1 = ((com.tencent.mm.plugin.masssend.a.a)getItem(paramInt - 1)).createTime;
      paramViewGroup = (com.tencent.mm.plugin.masssend.a.a)getItem(paramInt);
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
        this.ETg[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.ETg[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
          break label531;
        }
        paramInt = 1;
        switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
        {
        default: 
          paramViewGroup = paramView;
          label174:
          paramView = (f)paramViewGroup.getTag();
          label260:
          if (paramInt != 0)
          {
            paramView.sGk.setVisibility(0);
            paramView.sGk.setText(f.d(this.iXq, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).ETl.setText(this.iXq.getResources().getQuantityString(R.j.emk, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ESE, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).ESE) }));
              if (this.ETh.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRd()))
              {
                ((f)localObject2).ETm.setSingleLine(false);
                ((f)localObject2).ETm.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).ETm;
      MMActivity localMMActivity = this.iXq;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).eRg() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).eRg().equals(""))) {
        break label1756;
      }
      paramView = "";
      ((TextView)localObject3).setText(l.b(localMMActivity, paramView, ((f)localObject2).ETm.getTextSize()));
      paramInt = (int)((f)localObject2).ETm.getTextSize();
      paramView = ((f)localObject2).ETm.getText().toString();
      com.tencent.mm.ci.a.fromDPToPix(this.iXq, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).ETp.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRd()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label502:
      j = 0;
      break label82;
      label508:
      this.ETg[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.ETg[paramInt] = 1;
      break label102;
      label531:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).ETs == ETc) {
          break label174;
        }
      }
      paramViewGroup = this.mYa.inflate(R.i.eix, null);
      ((f)localObject2).ETl = ((TextView)paramViewGroup.findViewById(R.h.dMa));
      ((f)localObject2).ETm = ((TextView)paramViewGroup.findViewById(R.h.dMc));
      ((f)localObject2).ETn = ((TextView)paramViewGroup.findViewById(R.h.dMd));
      ((f)localObject2).ETp = ((TextView)paramViewGroup.findViewById(R.h.dLY));
      ((f)localObject2).sGk = ((TextView)paramViewGroup.findViewById(R.h.dMi));
      ((f)localObject2).ETr = paramViewGroup.findViewById(R.h.dLZ);
      ((f)localObject2).ETs = ETc;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).ETs == ETf) {
          break label174;
        }
      }
      paramViewGroup = this.mYa.inflate(R.i.eiz, null);
      ((f)localObject2).ETl = ((TextView)paramViewGroup.findViewById(R.h.dMa));
      ((f)localObject2).ETm = ((TextView)paramViewGroup.findViewById(R.h.dMc));
      ((f)localObject2).ETo = ((TextView)paramViewGroup.findViewById(R.h.dMb));
      ((f)localObject2).ETn = ((TextView)paramViewGroup.findViewById(R.h.dMh));
      ((f)localObject2).ETq = ((AnimImageView)paramViewGroup.findViewById(R.h.dMg));
      ((f)localObject2).ETp = ((TextView)paramViewGroup.findViewById(R.h.dLY));
      ((f)localObject2).sGk = ((TextView)paramViewGroup.findViewById(R.h.dMi));
      ((f)localObject2).ETr = paramViewGroup.findViewById(R.h.dLZ);
      ((f)localObject2).ETs = ETf;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).ETs == ETd) {
          break label174;
        }
      }
      paramViewGroup = this.mYa.inflate(R.i.eiw, null);
      ((f)localObject2).ETl = ((TextView)paramViewGroup.findViewById(R.h.dMa));
      ((f)localObject2).ETm = ((TextView)paramViewGroup.findViewById(R.h.dMc));
      ((f)localObject2).pDJ = ((ImageView)paramViewGroup.findViewById(R.h.dMe));
      ((f)localObject2).ETp = ((TextView)paramViewGroup.findViewById(R.h.dLY));
      ((f)localObject2).sGk = ((TextView)paramViewGroup.findViewById(R.h.dMi));
      ((f)localObject2).ETr = paramViewGroup.findViewById(R.h.dLZ);
      ((f)localObject2).ETs = ETd;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).ETs == ETe) {
          break label174;
        }
      }
      paramViewGroup = this.mYa.inflate(R.i.eiy, null);
      ((f)localObject2).ETl = ((TextView)paramViewGroup.findViewById(R.h.dMa));
      ((f)localObject2).ETm = ((TextView)paramViewGroup.findViewById(R.h.dMc));
      ((f)localObject2).pDJ = ((ImageView)paramViewGroup.findViewById(R.h.dMe));
      ((f)localObject2).ETo = ((TextView)paramViewGroup.findViewById(R.h.dMf));
      ((f)localObject2).ETp = ((TextView)paramViewGroup.findViewById(R.h.dLY));
      ((f)localObject2).sGk = ((TextView)paramViewGroup.findViewById(R.h.dMi));
      ((f)localObject2).ETr = paramViewGroup.findViewById(R.h.dLZ);
      ((f)localObject2).ETs = ETe;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.sGk.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.ETn.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRe());
      l.q(paramView.ETn, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = com.tencent.mm.modelvoice.s.GW(((com.tencent.mm.plugin.masssend.a.a)localObject1).ESF);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).eRd().equals(this.ETi))
      {
        paramView.ETq.setVisibility(0);
        paramView.ETq.cjx();
        paramView.ETn.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.ETo.setText(this.iXq.getString(R.l.eFR, new Object[] { Integer.valueOf((int)f) }));
        paramView.ETn.setWidth(com.tencent.mm.ci.a.fromDPToPix(paramView.ETn.getContext(), Wu((int)f)));
        paramView.ETq.setWidth(com.tencent.mm.ci.a.fromDPToPix(paramView.ETn.getContext(), Wu((int)f)));
        paramView.ETn.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRd()));
        break;
        paramView.ETq.setVisibility(8);
        paramView.ETq.cTg();
        paramView.ETn.setCompoundDrawablesWithIntrinsicBounds(null, null, this.iXq.getResources().getDrawable(R.k.chatto_voice_playing), null);
      }
      paramView = (f)paramViewGroup.getTag();
      bh.beI();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        h.eRm();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.aNU(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRe());
        if (localObject2 != null) {
          paramView.pDJ.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.pDJ.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRe(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).ESI));
        break;
        h.eRm();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.i(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRf(), com.tencent.mm.ci.a.getDensity(paramView.pDJ.getContext()));
        paramView.pDJ.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.pDJ.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.g.nosdcard_chatting_bg));
      }
      paramView = (f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.s.bqB();
      localObject2 = x.XU(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRe());
      localObject2 = q.bmh().a((String)localObject2, com.tencent.mm.ci.a.getDensity(paramView.pDJ.getContext()), -1);
      if (localObject2 == null)
      {
        bh.beI();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.pDJ.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.k.video_no_sd_icon));
        }
      }
      for (;;)
      {
        paramView.pDJ.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.a.a)localObject1).eRe(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).faO, ((com.tencent.mm.plugin.masssend.a.a)localObject1).ESF));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1707;
        }
        paramView.ETo.setVisibility(8);
        break;
        paramView.pDJ.setImageDrawable(com.tencent.mm.ci.a.m(this.iXq, R.e.grey_color_01));
        continue;
        paramView.pDJ.setImageBitmap((Bitmap)localObject2);
      }
      label1707:
      paramView.ETo.setVisibility(0);
      paramView.ETo.setText(Util.formatSecToMin(((com.tencent.mm.plugin.masssend.a.a)localObject1).ESF));
      break label260;
      ((f)localObject2).ETm.setSingleLine(true);
      ((f)localObject2).ETm.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1756:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).eRg().split(";");
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
        String str = aa.PJ((String)paramView.get(paramInt));
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
    private int ESI;
    private String fileName;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.ESI = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      Log.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      bh.beI();
      paramView = com.tencent.mm.model.c.bbW() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!u.agG(paramView)))
      {
        Log.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_compress_type", this.ESI);
      ((Intent)localObject).putExtra("key_favorite", false);
      ((Intent)localObject).putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.dhe().d(c.a(c.this), (Intent)localObject);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = h.eRm().aNV(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).eRg());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aFh(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.sf(0));
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
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26407);
        return;
      }
      if (this.videoSource == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.modelvideo.s.bqB();
        boolean bool2 = com.tencent.mm.modelvideo.v.XI(x.XT(this.fileName));
        Log.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.mIG.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
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
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).aOa(this.id));
        c.this.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String aOa(String paramString);
  }
  
  static final class f
  {
    TextView ETl;
    TextView ETm;
    TextView ETn;
    TextView ETo;
    TextView ETp;
    AnimImageView ETq;
    View ETr;
    short ETs;
    ImageView pDJ;
    TextView sGk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */