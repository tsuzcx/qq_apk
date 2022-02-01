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
import com.tencent.mm.aw.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.r<com.tencent.mm.plugin.masssend.a.a>
{
  private static short vHB = 1;
  private static short vHC = 2;
  private static short vHD = 3;
  private static short vHE = 4;
  private MMActivity fLP;
  int fTM;
  private LayoutInflater jfG;
  int oIZ;
  private short[] vHF;
  private List<String> vHG;
  String vHH;
  e vHI;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.vHH = "";
    this.fLP = ((MMActivity)paramContext);
    this.vHG = new LinkedList();
    this.oIZ = 10;
    this.fTM = this.oIZ;
    this.jfG = z.jO(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int JH(int paramInt)
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
  
  private void dle()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.vHF = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(26411);
    this.fTM = h.dkT().dkO();
    setCursor(h.dkT().IE(this.oIZ));
    dle();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(26410);
    Zu();
    AppMethodBeat.o(26410);
  }
  
  public final void app(String paramString)
  {
    AppMethodBeat.i(26413);
    this.vHH = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final boolean bXb()
  {
    return this.oIZ >= this.fTM;
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
        this.vHF[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.vHF[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
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
            paramView.umZ.setVisibility(0);
            paramView.umZ.setText(com.tencent.mm.pluginsdk.i.i.c(this.fLP, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).vHK.setText(this.fLP.getResources().getQuantityString(2131623955, ((com.tencent.mm.plugin.masssend.a.a)localObject1).vHd, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).vHd) }));
              if (this.vHG.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK()))
              {
                ((f)localObject2).vHL.setSingleLine(false);
                ((f)localObject2).vHL.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).vHL;
      MMActivity localMMActivity = this.fLP;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).dkN() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).dkN().equals(""))) {
        break label1758;
      }
      paramView = "";
      ((TextView)localObject3).setText(k.b(localMMActivity, paramView, ((f)localObject2).vHL.getTextSize()));
      paramInt = (int)((f)localObject2).vHL.getTextSize();
      paramView = ((f)localObject2).vHL.getText().toString();
      com.tencent.mm.cc.a.fromDPToPix(this.fLP, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).vHO.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.vHF[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.vHF[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vHR == vHB) {
          break label174;
        }
      }
      paramViewGroup = this.jfG.inflate(2131494737, null);
      ((f)localObject2).vHK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vHL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).vHM = ((TextView)paramViewGroup.findViewById(2131302180));
      ((f)localObject2).vHO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).umZ = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vHQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vHR = vHB;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vHR == vHE) {
          break label174;
        }
      }
      paramViewGroup = this.jfG.inflate(2131494739, null);
      ((f)localObject2).vHK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vHL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).vHN = ((TextView)paramViewGroup.findViewById(2131302177));
      ((f)localObject2).vHM = ((TextView)paramViewGroup.findViewById(2131302184));
      ((f)localObject2).vHP = ((AnimImageView)paramViewGroup.findViewById(2131302183));
      ((f)localObject2).vHO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).umZ = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vHQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vHR = vHE;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vHR == vHC) {
          break label174;
        }
      }
      paramViewGroup = this.jfG.inflate(2131494736, null);
      ((f)localObject2).vHK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vHL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).lta = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).vHO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).umZ = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vHQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vHR = vHC;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).vHR == vHD) {
          break label174;
        }
      }
      paramViewGroup = this.jfG.inflate(2131494738, null);
      ((f)localObject2).vHK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).vHL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).lta = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).vHN = ((TextView)paramViewGroup.findViewById(2131302182));
      ((f)localObject2).vHO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).umZ = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).vHQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).vHR = vHD;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.umZ.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.vHM.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkL());
      k.n(paramView.vHM, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = s.sv(((com.tencent.mm.plugin.masssend.a.a)localObject1).vHe);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK().equals(this.vHH))
      {
        paramView.vHP.setVisibility(0);
        paramView.vHP.bzc();
        paramView.vHM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.vHN.setText(this.fLP.getString(2131759570, new Object[] { Integer.valueOf((int)f) }));
        paramView.vHM.setWidth(com.tencent.mm.cc.a.fromDPToPix(paramView.vHM.getContext(), JH((int)f)));
        paramView.vHP.setWidth(com.tencent.mm.cc.a.fromDPToPix(paramView.vHM.getContext(), JH((int)f)));
        paramView.vHM.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkK()));
        break;
        paramView.vHP.setVisibility(8);
        paramView.vHP.cfx();
        paramView.vHM.setCompoundDrawablesWithIntrinsicBounds(null, null, this.fLP.getResources().getDrawable(2131689927), null);
      }
      paramView = (f)paramViewGroup.getTag();
      ba.aBQ();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        h.dkT();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.apk(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkL());
        if (localObject2 != null) {
          paramView.lta.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.lta.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkL(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).vHh));
        break;
        h.dkT();
        localObject2 = com.tencent.mm.plugin.masssend.a.b.j(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkM(), com.tencent.mm.cc.a.getDensity(paramView.lta.getContext()));
        paramView.lta.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.lta.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131233476));
      }
      paramView = (f)paramViewGroup.getTag();
      o.aMJ();
      localObject2 = com.tencent.mm.modelvideo.t.Hi(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkL());
      localObject2 = q.aIF().a((String)localObject2, com.tencent.mm.cc.a.getDensity(paramView.lta.getContext()), this.fLP);
      if (localObject2 == null)
      {
        ba.aBQ();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.lta.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131691365));
        }
      }
      for (;;)
      {
        paramView.lta.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.a.a)localObject1).dkL(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).cSb, ((com.tencent.mm.plugin.masssend.a.a)localObject1).vHe));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1709;
        }
        paramView.vHN.setVisibility(8);
        break;
        paramView.lta.setImageDrawable(com.tencent.mm.cc.a.l(this.fLP, 2131100478));
        continue;
        paramView.lta.setImageBitmap((Bitmap)localObject2);
      }
      label1709:
      paramView.vHN.setVisibility(0);
      paramView.vHN.setText(bt.qY(((com.tencent.mm.plugin.masssend.a.a)localObject1).vHe));
      break label260;
      ((f)localObject2).vHL.setSingleLine(true);
      ((f)localObject2).vHL.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1758:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dkN().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bt.U((String[])localObject4);
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
        String str = v.zf((String)paramView.get(paramInt));
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
    private int vHh;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.vHh = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      ad.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      ba.aBQ();
      paramView = com.tencent.mm.model.c.azA() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!com.tencent.mm.vfs.i.fv(paramView)))
      {
        ad.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnImageClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26405);
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_compress_type", this.vHh);
      ((Intent)localObject).putExtra("key_favorite", false);
      ((Intent)localObject).putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.iRG.d(c.a(c.this), (Intent)localObject);
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = h.dkT().apl(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).dkN());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.ahp(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.mq(0));
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVideoClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ba.aBQ();
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
        o.aMJ();
        boolean bool2 = com.tencent.mm.modelvideo.r.GW(com.tencent.mm.modelvideo.t.Hh(this.fileName));
        ad.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.iRG.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).apq(this.id));
        c.this.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnVoiceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String apq(String paramString);
  }
  
  static final class f
  {
    ImageView lta;
    TextView umZ;
    TextView vHK;
    TextView vHL;
    TextView vHM;
    TextView vHN;
    TextView vHO;
    AnimImageView vHP;
    View vHQ;
    short vHR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */