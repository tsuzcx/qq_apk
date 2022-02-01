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
import com.tencent.mm.av.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.r<com.tencent.mm.plugin.masssend.a.a>
{
  private static short vTF = 1;
  private static short vTG = 2;
  private static short vTH = 3;
  private static short vTI = 4;
  private MMActivity fNT;
  int fVS;
  private LayoutInflater jiz;
  int oPB;
  private short[] vTJ;
  private List<String> vTK;
  String vTL;
  e vTM;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.vTL = "";
    this.fNT = ((MMActivity)paramContext);
    this.vTK = new LinkedList();
    this.oPB = 10;
    this.fVS = this.oPB;
    this.jiz = z.jV(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int Kg(int paramInt)
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
  
  private void doe()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.vTJ = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(26411);
    this.fVS = h.dnT().dnO();
    setCursor(h.dnT().Jc(this.oPB));
    doe();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(26410);
    ZD();
    AppMethodBeat.o(26410);
  }
  
  public final void aqu(String paramString)
  {
    AppMethodBeat.i(26413);
    this.vTL = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final boolean bYq()
  {
    return this.oPB >= this.fVS;
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
          break label501;
        }
        j = 1;
        if ((i == 0) && (j == 0)) {
          break label507;
        }
        this.vTJ[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.vTJ[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
          break label530;
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
            paramView.okL.setVisibility(0);
            paramView.okL.setText(com.tencent.mm.pluginsdk.i.i.c(this.fNT, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).vTO.setText(this.fNT.getResources().getQuantityString(2131623955, ((com.tencent.mm.plugin.masssend.a.a)localObject1).vTh, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).vTh) }));
              if (this.vTK.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK()))
              {
                ((f)localObject2).vTP.setSingleLine(false);
                ((f)localObject2).vTP.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).vTP;
      MMActivity localMMActivity = this.fNT;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).dnN() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).dnN().equals(""))) {
        break label1758;
      }
      paramView = "";
      ((TextView)localObject3).setText(k.b(localMMActivity, paramView, ((f)localObject2).vTP.getTextSize()));
      paramInt = (int)((f)localObject2).vTP.getTextSize();
      paramView = ((f)localObject2).vTP.getText().toString();
      com.tencent.mm.cb.a.fromDPToPix(this.fNT, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).vTS.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.vTJ[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.vTJ[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vTV == vTF) {
          break label174;
        }
      }
      paramViewGroup = this.jiz.inflate(2131494737, null);
      ((f)localObject2).vTO = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vTP = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).vTQ = ((TextView)paramViewGroup.findViewById(2131302180));
      ((f)localObject2).vTS = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).okL = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vTU = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vTV = vTF;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vTV == vTI) {
          break label174;
        }
      }
      paramViewGroup = this.jiz.inflate(2131494739, null);
      ((f)localObject2).vTO = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vTP = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).vTR = ((TextView)paramViewGroup.findViewById(2131302177));
      ((f)localObject2).vTQ = ((TextView)paramViewGroup.findViewById(2131302184));
      ((f)localObject2).vTT = ((AnimImageView)paramViewGroup.findViewById(2131302183));
      ((f)localObject2).vTS = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).okL = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vTU = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vTV = vTI;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vTV == vTG) {
          break label174;
        }
      }
      paramViewGroup = this.jiz.inflate(2131494736, null);
      ((f)localObject2).vTO = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vTP = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).lxz = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).vTS = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).okL = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vTU = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vTV = vTG;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vTV == vTH) {
          break label174;
        }
      }
      paramViewGroup = this.jiz.inflate(2131494738, null);
      ((f)localObject2).vTO = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vTP = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).lxz = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).vTR = ((TextView)paramViewGroup.findViewById(2131302182));
      ((f)localObject2).vTS = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).okL = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vTU = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vTV = vTH;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.okL.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.vTQ.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnL());
      k.o(paramView.vTQ, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = s.sI(((com.tencent.mm.plugin.masssend.a.a)localObject1).vTi);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK().equals(this.vTL))
      {
        paramView.vTT.setVisibility(0);
        paramView.vTT.bzX();
        paramView.vTQ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.vTR.setText(this.fNT.getString(2131759570, new Object[] { Integer.valueOf((int)f) }));
        paramView.vTQ.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.vTQ.getContext(), Kg((int)f)));
        paramView.vTT.setWidth(com.tencent.mm.cb.a.fromDPToPix(paramView.vTQ.getContext(), Kg((int)f)));
        paramView.vTQ.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnK()));
        break;
        paramView.vTT.setVisibility(8);
        paramView.vTT.cgN();
        paramView.vTQ.setCompoundDrawablesWithIntrinsicBounds(null, null, this.fNT.getResources().getDrawable(2131689927), null);
      }
      paramView = (f)paramViewGroup.getTag();
      bc.aCg();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        h.dnT();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.aqp(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnL());
        if (localObject2 != null) {
          paramView.lxz.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.lxz.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnL(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).vTl));
        break;
        h.dnT();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.j(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnM(), com.tencent.mm.cb.a.getDensity(paramView.lxz.getContext()));
        paramView.lxz.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.lxz.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131233476));
      }
      paramView = (f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.o.aNh();
      localObject2 = com.tencent.mm.modelvideo.t.HK(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnL());
      localObject2 = q.aIX().a((String)localObject2, com.tencent.mm.cb.a.getDensity(paramView.lxz.getContext()), this.fNT);
      if (localObject2 == null)
      {
        bc.aCg();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.lxz.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131691365));
        }
      }
      for (;;)
      {
        paramView.lxz.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.a.a)localObject1).dnL(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).cSL, ((com.tencent.mm.plugin.masssend.a.a)localObject1).vTi));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1709;
        }
        paramView.vTR.setVisibility(8);
        break;
        paramView.lxz.setImageDrawable(com.tencent.mm.cb.a.l(this.fNT, 2131100478));
        continue;
        paramView.lxz.setImageBitmap((Bitmap)localObject2);
      }
      label1709:
      paramView.vTR.setVisibility(0);
      paramView.vTR.setText(bu.rb(((com.tencent.mm.plugin.masssend.a.a)localObject1).vTi));
      break label260;
      ((f)localObject2).vTP.setSingleLine(true);
      ((f)localObject2).vTP.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1758:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dnN().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bu.U((String[])localObject4);
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
        String str = w.zP((String)paramView.get(paramInt));
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
    private String fileName;
    private int vTl;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.vTl = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      ae.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      bc.aCg();
      paramView = com.tencent.mm.model.c.azQ() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!com.tencent.mm.vfs.o.fB(paramView)))
      {
        ae.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_compress_type", this.vTl);
      ((Intent)localObject).putExtra("key_favorite", false);
      ((Intent)localObject).putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.iUz.d(c.a(c.this), (Intent)localObject);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = h.dnT().aqq(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).dnN());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahE(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26407);
        return;
      }
      if (this.videoSource == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.modelvideo.o.aNh();
        boolean bool2 = com.tencent.mm.modelvideo.r.Hy(com.tencent.mm.modelvideo.t.HJ(this.fileName));
        ae.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.iUz.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
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
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).aqv(this.id));
        c.this.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String aqv(String paramString);
  }
  
  static final class f
  {
    ImageView lxz;
    TextView okL;
    TextView vTO;
    TextView vTP;
    TextView vTQ;
    TextView vTR;
    TextView vTS;
    AnimImageView vTT;
    View vTU;
    short vTV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */