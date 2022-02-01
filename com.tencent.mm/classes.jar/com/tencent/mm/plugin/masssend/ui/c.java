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
import com.tencent.mm.av.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c
  extends com.tencent.mm.ui.r<com.tencent.mm.plugin.masssend.a.a>
{
  private static short uEB = 1;
  private static short uEC = 2;
  private static short uED = 3;
  private static short uEE = 4;
  int fAw;
  private MMActivity iMV;
  private LayoutInflater iMw;
  int ofG;
  private short[] uEF;
  private List<String> uEG;
  String uEH;
  e uEI;
  
  public c(Context paramContext)
  {
    super(paramContext, new com.tencent.mm.plugin.masssend.a.a());
    AppMethodBeat.i(26409);
    this.uEH = "";
    this.iMV = ((MMActivity)paramContext);
    this.uEG = new LinkedList();
    this.ofG = 10;
    this.fAw = this.ofG;
    this.iMw = z.jD(paramContext);
    AppMethodBeat.o(26409);
  }
  
  private static int Il(int paramInt)
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
  
  private void dbK()
  {
    AppMethodBeat.i(26414);
    int i = getCount();
    if (i <= 0)
    {
      AppMethodBeat.o(26414);
      return;
    }
    this.uEF = new short[i];
    AppMethodBeat.o(26414);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(26411);
    this.fAw = com.tencent.mm.plugin.masssend.a.h.dbz().dbu();
    setCursor(com.tencent.mm.plugin.masssend.a.h.dbz().Hi(this.ofG));
    dbK();
    super.notifyDataSetChanged();
    AppMethodBeat.o(26411);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(26410);
    Xb();
    AppMethodBeat.o(26410);
  }
  
  public final void akC(String paramString)
  {
    AppMethodBeat.i(26413);
    this.uEH = paramString;
    notifyDataSetChanged();
    AppMethodBeat.o(26413);
  }
  
  public final boolean bSw()
  {
    return this.ofG >= this.fAw;
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
        this.uEF[paramInt] = 2;
        localObject1 = paramViewGroup;
        if ((this.uEF[paramInt] != 1) || (((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime <= 1000L)) {
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
            paramView.toC.setVisibility(0);
            paramView.toC.setText(com.tencent.mm.pluginsdk.g.h.c(this.iMV, ((com.tencent.mm.plugin.masssend.a.a)localObject1).createTime, false));
            label214:
            switch (((com.tencent.mm.plugin.masssend.a.a)localObject1).msgType)
            {
            default: 
              localObject2 = (f)paramViewGroup.getTag();
              ((f)localObject2).uEK.setText(this.iMV.getResources().getQuantityString(2131623955, ((com.tencent.mm.plugin.masssend.a.a)localObject1).uEd, new Object[] { Integer.valueOf(((com.tencent.mm.plugin.masssend.a.a)localObject1).uEd) }));
              if (this.uEG.contains(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq()))
              {
                ((f)localObject2).uEL.setSingleLine(false);
                ((f)localObject2).uEL.setEllipsize(null);
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
      Object localObject3 = ((f)localObject2).uEL;
      MMActivity localMMActivity = this.iMV;
      paramView = new ArrayList();
      if ((((com.tencent.mm.plugin.masssend.a.a)localObject1).dbt() != null) && (!((com.tencent.mm.plugin.masssend.a.a)localObject1).dbt().equals(""))) {
        break label1758;
      }
      paramView = "";
      ((TextView)localObject3).setText(k.b(localMMActivity, paramView, ((f)localObject2).uEL.getTextSize()));
      paramInt = (int)((f)localObject2).uEL.getTextSize();
      paramView = ((f)localObject2).uEL.getText().toString();
      com.tencent.mm.cc.a.fromDPToPix(this.iMV, 255);
      localObject3 = new Paint();
      ((Paint)localObject3).setTextSize(paramInt);
      ((Paint)localObject3).measureText(paramView);
      ((f)localObject2).uEO.setOnClickListener(new b(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq()));
      AppMethodBeat.o(26412);
      return paramViewGroup;
      i = 0;
      break;
      label501:
      j = 0;
      break label82;
      label507:
      this.uEF[paramInt] = 1;
      localObject1 = paramViewGroup;
      break label102;
      this.uEF[paramInt] = 1;
      break label102;
      label530:
      paramInt = 0;
      break label126;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).uER == uEB) {
          break label174;
        }
      }
      paramViewGroup = this.iMw.inflate(2131494737, null);
      ((f)localObject2).uEK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).uEL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).uEM = ((TextView)paramViewGroup.findViewById(2131302180));
      ((f)localObject2).uEO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).toC = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).uEQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).uER = uEB;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).uER == uEE) {
          break label174;
        }
      }
      paramViewGroup = this.iMw.inflate(2131494739, null);
      ((f)localObject2).uEK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).uEL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).uEN = ((TextView)paramViewGroup.findViewById(2131302177));
      ((f)localObject2).uEM = ((TextView)paramViewGroup.findViewById(2131302184));
      ((f)localObject2).uEP = ((AnimImageView)paramViewGroup.findViewById(2131302183));
      ((f)localObject2).uEO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).toC = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).uEQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).uER = uEE;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).uER == uEC) {
          break label174;
        }
      }
      paramViewGroup = this.iMw.inflate(2131494736, null);
      ((f)localObject2).uEK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).uEL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).kWb = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).uEO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).toC = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).uEQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).uER = uEC;
      paramViewGroup.setTag(localObject2);
      break label174;
      localObject2 = new f();
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if (((f)paramView.getTag()).uER == uED) {
          break label174;
        }
      }
      paramViewGroup = this.iMw.inflate(2131494738, null);
      ((f)localObject2).uEK = ((TextView)paramViewGroup.findViewById(2131302176));
      ((f)localObject2).uEL = ((TextView)paramViewGroup.findViewById(2131302179));
      ((f)localObject2).kWb = ((ImageView)paramViewGroup.findViewById(2131302181));
      ((f)localObject2).uEN = ((TextView)paramViewGroup.findViewById(2131302182));
      ((f)localObject2).uEO = ((TextView)paramViewGroup.findViewById(2131302174));
      ((f)localObject2).toC = ((TextView)paramViewGroup.findViewById(2131302185));
      ((f)localObject2).uEQ = paramViewGroup.findViewById(2131302175);
      ((f)localObject2).uER = uED;
      paramViewGroup.setTag(localObject2);
      break label174;
      paramView.toC.setVisibility(8);
      break label214;
      paramView = (f)paramViewGroup.getTag();
      paramView.uEM.setText(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbr());
      k.m(paramView.uEM, 1);
      break label260;
      paramView = (f)paramViewGroup.getTag();
      float f = s.qw(((com.tencent.mm.plugin.masssend.a.a)localObject1).uEe);
      if (((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq().equals(this.uEH))
      {
        paramView.uEP.setVisibility(0);
        paramView.uEP.fia();
        paramView.uEM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
      for (;;)
      {
        paramView.uEN.setText(this.iMV.getString(2131759570, new Object[] { Integer.valueOf((int)f) }));
        paramView.uEM.setWidth(com.tencent.mm.cc.a.fromDPToPix(paramView.uEM.getContext(), Il((int)f)));
        paramView.uEP.setWidth(com.tencent.mm.cc.a.fromDPToPix(paramView.uEM.getContext(), Il((int)f)));
        paramView.uEM.setOnClickListener(new d(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbq()));
        break;
        paramView.uEP.setVisibility(8);
        paramView.uEP.caT();
        paramView.uEM.setCompoundDrawablesWithIntrinsicBounds(null, null, this.iMV.getResources().getDrawable(2131689927), null);
      }
      paramView = (f)paramViewGroup.getTag();
      az.ayM();
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.plugin.masssend.a.h.dbz();
        localObject2 = b.akx(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbr());
        if (localObject2 != null) {
          paramView.kWb.setImageBitmap((Bitmap)localObject2);
        }
      }
      for (;;)
      {
        paramView.kWb.setOnClickListener(new a(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbr(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).uEh));
        break;
        com.tencent.mm.plugin.masssend.a.h.dbz();
        localObject2 = b.j(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbs(), com.tencent.mm.cc.a.getDensity(paramView.kWb.getContext()));
        paramView.kWb.setImageBitmap((Bitmap)localObject2);
        continue;
        paramView.kWb.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131233476));
      }
      paramView = (f)paramViewGroup.getTag();
      com.tencent.mm.modelvideo.o.aJy();
      localObject2 = com.tencent.mm.modelvideo.t.DW(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbr());
      localObject2 = com.tencent.mm.av.o.aFx().a((String)localObject2, com.tencent.mm.cc.a.getDensity(paramView.kWb.getContext()), this.iMV);
      if (localObject2 == null)
      {
        az.ayM();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
          paramView.kWb.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131691365));
        }
      }
      for (;;)
      {
        paramView.kWb.setOnClickListener(new c(((com.tencent.mm.plugin.masssend.a.a)localObject1).dbr(), ((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource, ((com.tencent.mm.plugin.masssend.a.a)localObject1).cGX, ((com.tencent.mm.plugin.masssend.a.a)localObject1).uEe));
        if (((com.tencent.mm.plugin.masssend.a.a)localObject1).videoSource != 2) {
          break label1709;
        }
        paramView.uEN.setVisibility(8);
        break;
        paramView.kWb.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131100478));
        continue;
        paramView.kWb.setImageBitmap((Bitmap)localObject2);
      }
      label1709:
      paramView.uEN.setVisibility(0);
      paramView.uEN.setText(bs.qy(((com.tencent.mm.plugin.masssend.a.a)localObject1).uEe));
      break label260;
      ((f)localObject2).uEL.setSingleLine(true);
      ((f)localObject2).uEL.setEllipsize(TextUtils.TruncateAt.END);
    }
    label1758:
    Object localObject4 = ((com.tencent.mm.plugin.masssend.a.a)localObject1).dbt().split(";");
    if ((localObject4 != null) && (localObject4.length > 0)) {
      paramView = bs.S((String[])localObject4);
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
        String str = v.wk((String)paramView.get(paramInt));
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
    private int uEh;
    
    public a(String paramString, int paramInt)
    {
      this.fileName = paramString;
      this.uEh = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(26405);
      ac.v("MicroMsg.HistoryAdapter", "image clicked:" + this.fileName);
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        AppMethodBeat.o(26405);
        return;
      }
      paramView = new StringBuilder();
      az.ayM();
      paramView = com.tencent.mm.model.c.awL() + this.fileName;
      if ((paramView == null) || (paramView.equals("")) || (!i.eA(paramView)))
      {
        ac.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
        AppMethodBeat.o(26405);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("key_compress_type", this.uEh);
      localIntent.putExtra("key_favorite", false);
      localIntent.putExtra("key_image_path", paramView);
      com.tencent.mm.plugin.masssend.a.iyx.d(c.a(c.this), localIntent);
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
      Object localObject = com.tencent.mm.plugin.masssend.a.h.dbz().aky(this.id);
      paramView = new Intent(c.a(c.this), MassSendMsgUI.class);
      paramView.putExtra("mass_send_contact_list", ((com.tencent.mm.plugin.masssend.a.a)localObject).dbt());
      paramView.putExtra("mass_send_again", true);
      localObject = c.a(c.this);
      paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/masssend/ui/MassSendHistoryAdapter$OnSendAgainClickListener", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMActivity)localObject).startActivity((Intent)paramView.lR(0));
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
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(c.a(c.this), null);
        AppMethodBeat.o(26407);
        return;
      }
      if (this.videoSource == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.tencent.mm.modelvideo.o.aJy();
        boolean bool2 = com.tencent.mm.modelvideo.r.DP(com.tencent.mm.modelvideo.t.DV(this.fileName));
        ac.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[] { this.fileName, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.masssend.a.iyx.a(bool1, bool2, c.a(c.this), this.fileName, this.length, this.size);
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
      ac.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
      if (c.b(c.this) != null)
      {
        c.a(c.this, c.b(c.this).akD(this.id));
        c.this.notifyDataSetChanged();
      }
      AppMethodBeat.o(26408);
    }
  }
  
  static abstract interface e
  {
    public abstract String akD(String paramString);
  }
  
  static final class f
  {
    ImageView kWb;
    TextView toC;
    TextView uEK;
    TextView uEL;
    TextView uEM;
    TextView uEN;
    TextView uEO;
    AnimImageView uEP;
    View uEQ;
    short uER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c
 * JD-Core Version:    0.7.0.1
 */