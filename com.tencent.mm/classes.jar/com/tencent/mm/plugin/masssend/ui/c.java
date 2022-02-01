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
import com.tencent.mm.aw.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.y;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends q<com.tencent.mm.plugin.masssend.a.a>
{
  private static short twj = 1;
  private static short twk = 2;
  private static short twl = 3;
  private static short twm = 4;
  int fwP;
  private MMActivity imP;
  private LayoutInflater imq;
  int nCF;
  private short[] twn;
  private List<String> two;
  String twp;
  e twq;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.twp = "";
    this.imP = ((MMActivity)paramContext);
    this.two = new LinkedList();
    this.nCF = 10;
    this.fwP = this.nCF;
    this.imq = y.js(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int Gp(int paramInt)
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
  
  private void cOc()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.twn = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(26411);
    this.fwP = com.tencent.mm.plugin.masssend.a.h.cNS().cNN();
    setCursor(com.tencent.mm.plugin.masssend.a.h.cNS().Fn(this.nCF));
    cOc();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void We()
  {
    AppMethodBeat.i(26410);
    Wd();
    AppMethodBeat.o(26410);
  }
  
  public final void afI(String paramString)
  {
    AppMethodBeat.i(26413);
    this.twp = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final boolean bLj()
  {
    return this.nCF >= this.fwP;
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
        this.twn[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.twn[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
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
            paramView.sgI.setVisibility(0);
            paramView.sgI.setText(com.tencent.mm.pluginsdk.g.h.c(this.imP, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).tws.setText(this.imP.getResources().getQuantityString(2131623955, ((com.tencent.mm.plugin.masssend.a.a)localObject1).tvK, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).tvK) }));
              if (this.two.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ()))
              {
                ((f)localObject2).twt.setSingleLine(false);
                ((f)localObject2).twt.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).twt;
      MMActivity localMMActivity = this.imP;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).cNM() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).cNM().equals(""))) {
        break label1758;
      }
      paramView = "";
      ((TextView)localObject3).setText(k.b(localMMActivity, paramView, ((f)localObject2).twt.getTextSize()));
      paramInt = (int)((f)localObject2).twt.getTextSize();
      paramView = ((f)localObject2).twt.getText().toString();
      com.tencent.mm.cd.a.fromDPToPix(this.imP, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).tww.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.twn[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.twn[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).twz == twj) {
          break label174;
        }
      }
      paramViewGroup = this.imq.inflate(2131494737, null);
      ((f)localObject2).tws = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).twt = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).twu = ((TextView)paramViewGroup.findViewById(2131302180));
      ((f)localObject2).tww = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).sgI = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).twy = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).twz = twj;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).twz == twm) {
          break label174;
        }
      }
      paramViewGroup = this.imq.inflate(2131494739, null);
      ((f)localObject2).tws = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).twt = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).twv = ((TextView)paramViewGroup.findViewById(2131302177));
      ((f)localObject2).twu = ((TextView)paramViewGroup.findViewById(2131302184));
      ((f)localObject2).twx = ((AnimImageView)paramViewGroup.findViewById(2131302183));
      ((f)localObject2).tww = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).sgI = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).twy = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).twz = twm;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).twz == twk) {
          break label174;
        }
      }
      paramViewGroup = this.imq.inflate(2131494736, null);
      ((f)localObject2).tws = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).twt = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).kuM = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).tww = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).sgI = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).twy = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).twz = twk;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).twz == twl) {
          break label174;
        }
      }
      paramViewGroup = this.imq.inflate(2131494738, null);
      ((f)localObject2).tws = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).twt = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).kuM = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).twv = ((TextView)paramViewGroup.findViewById(2131302182));
      ((f)localObject2).tww = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).sgI = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).twy = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).twz = twl;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.sgI.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.twu.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNK());
      k.m(paramView.twu, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = s.mI(((com.tencent.mm.plugin.masssend.a.a)localObject1).tvL);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ().equals(this.twp))
      {
        paramView.twx.setVisibility(0);
        paramView.twx.eSq();
        paramView.twu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.twv.setText(this.imP.getString(2131759570, new Object[] { Integer.valueOf((int)f) }));
        paramView.twu.setWidth(com.tencent.mm.cd.a.fromDPToPix(paramView.twu.getContext(), Gp((int)f)));
        paramView.twx.setWidth(com.tencent.mm.cd.a.fromDPToPix(paramView.twu.getContext(), Gp((int)f)));
        paramView.twu.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNJ()));
        break;
        paramView.twx.setVisibility(8);
        paramView.twx.bTF();
        paramView.twu.setCompoundDrawablesWithIntrinsicBounds(null, null, this.imP.getResources().getDrawable(2131689927), null);
      }
      paramView = (f)paramViewGroup.getTag();
      az.arV();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.plugin.masssend.a.h.cNS();
        localObject2 = b.afD(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNK());
        if (localObject2 != null) {
          paramView.kuM.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.kuM.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNK(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).tvO));
        break;
        com.tencent.mm.plugin.masssend.a.h.cNS();
        localObject2 = b.j(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNL(), com.tencent.mm.cd.a.getDensity(paramView.kuM.getContext()));
        paramView.kuM.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.kuM.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131233476));
      }
      paramView = (f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.o.aCI();
      localObject2 = com.tencent.mm.modelvideo.t.zR(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNK());
      localObject2 = com.tencent.mm.aw.o.ayF().a((String)localObject2, com.tencent.mm.cd.a.getDensity(paramView.kuM.getContext()), this.imP);
      if (localObject2 == null)
      {
        az.arV();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.kuM.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131691365));
        }
      }
      for (;;)
      {
        paramView.kuM.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.a.a)localObject1).cNK(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).cJQ, ((com.tencent.mm.plugin.masssend.a.a)localObject1).tvL));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1709;
        }
        paramView.twv.setVisibility(8);
        break;
        paramView.kuM.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131100478));
        continue;
        paramView.kuM.setImageBitmap((Bitmap)localObject2);
      }
      label1709:
      paramView.twv.setVisibility(0);
      paramView.twv.setText(bt.pL(((com.tencent.mm.plugin.masssend.a.a)localObject1).tvL));
      break label260;
      ((f)localObject2).twt.setSingleLine(true);
      ((f)localObject2).twt.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1758:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).cNM().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bt.S((String[])localObject4);
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
        String str = v.sh((String)paramView.get(paramInt));
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
    private int tvO;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.tvO = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      ad.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      az.arV();
      paramView = com.tencent.mm.model.c.apW() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!i.eK(paramView)))
      {
        ad.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        AppMethodBeat.o(26405);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_compress_type", this.tvO);
      localIntent.putExtra("key_favorite", false);
      localIntent.putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.hYt.d(c.a(c.this), localIntent);
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
      Object localObject = com.tencent.mm.plugin.masssend.a.h.cNS().afE(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).cNM());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.adn(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        AppMethodBeat.o(26407);
        return;
      }
      if (this.videoSource == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.modelvideo.o.aCI();
        boolean bool2 = r.zK(com.tencent.mm.modelvideo.t.zQ(this.fileName));
        ad.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.hYt.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
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
      ad.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).afJ(this.id));
        c.this.notifyDataSetChanged();
      }
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String afJ(String paramString);
  }
  
  static final class f
  {
    ImageView kuM;
    TextView sgI;
    TextView tws;
    TextView twt;
    TextView twu;
    TextView twv;
    TextView tww;
    AnimImageView twx;
    View twy;
    short twz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */