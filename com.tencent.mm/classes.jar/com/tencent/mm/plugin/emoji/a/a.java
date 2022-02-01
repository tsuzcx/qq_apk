package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.j.a;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
{
  private final String TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
  protected View iIW;
  protected TextView kEu;
  Context mContext;
  private LayoutInflater mLayoutInflater;
  public int mPosition;
  private View otd;
  private final int ote = 2131493771;
  private final int otf = 2131493808;
  private final int otg = 2131493809;
  private int[] oth = { -1, -1 };
  private int oti = -1;
  public f otj;
  protected View otk;
  protected ImageView otl;
  protected ImageView otm;
  protected View otn;
  protected TextView oto;
  protected TextView otp;
  protected ProgressBar otq;
  protected ViewGroup otr;
  protected View ots;
  protected TextView ott;
  protected ImageView otu;
  protected View otv;
  protected ProgressBar otw;
  protected TextView otx;
  protected TextView oty;
  protected FrameLayout otz;
  
  public a(Context paramContext, View paramView)
  {
    this(paramContext, paramView, a.otD);
  }
  
  private a(Context paramContext, View paramView, a parama)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
    paramContext = paramView;
    if (paramView == null) {}
    label446:
    int i;
    switch (2.otC[parama.ordinal()])
    {
    default: 
      paramContext = Am(this.ote);
      this.iIW = paramContext;
      if (paramContext != null)
      {
        this.otd = paramContext;
        this.otk = this.otd.findViewById(2131301144);
        this.otm = ((ImageView)this.otd.findViewById(2131301197));
        this.otl = ((ImageView)this.otd.findViewById(2131301154));
        this.kEu = ((TextView)this.otd.findViewById(2131301169));
        this.otn = this.otd.findViewById(2131301171);
        this.oto = ((TextView)this.otd.findViewById(2131301146));
        this.otp = ((TextView)this.otd.findViewById(2131301157));
        this.otq = ((ProgressBar)this.otd.findViewById(2131303403));
        this.ots = this.otd.findViewById(2131301174);
        this.otr = ((ViewGroup)this.otd.findViewById(2131301185));
        this.ott = ((TextView)this.otd.findViewById(2131301192));
        this.otu = ((ImageView)this.otd.findViewById(2131301194));
        this.otv = this.otd.findViewById(2131301183);
        this.otw = ((ProgressBar)this.otd.findViewById(2131301151));
        this.otx = ((TextView)this.otd.findViewById(2131301142));
        this.oty = ((TextView)this.otd.findViewById(2131301172));
        this.otz = ((FrameLayout)this.otd.findViewById(2131301166));
      }
      bTZ();
      if (parama == a.otD)
      {
        paramView = bUa();
        if ((this.otl != null) && (paramView[0] >= 0) && (paramView[1] >= 0) && ((paramView[0] != this.oth[0]) || (paramView[1] != this.oth[1]))) {
          break label515;
        }
        i = bUb();
        if ((this.otd != null) && (i >= 0) && (this.oti != i)) {
          break label553;
        }
      }
      break;
    }
    for (;;)
    {
      paramContext.setTag(this);
      return;
      paramContext = Am(this.ote);
      break;
      paramContext = Am(this.otg);
      break;
      paramContext = Am(this.otf);
      break;
      label515:
      parama = this.otl.getLayoutParams();
      parama.width = paramView[0];
      parama.height = paramView[1];
      this.otl.setLayoutParams(parama);
      this.oth = paramView;
      break label446;
      label553:
      this.otd.setMinimumHeight(i);
      if (this.otk != null) {
        this.otk.setMinimumHeight(i);
      }
    }
  }
  
  private View Am(int paramInt)
  {
    if ((this.mLayoutInflater == null) || (paramInt <= 0)) {
      return null;
    }
    return this.mLayoutInflater.inflate(paramInt, null);
  }
  
  private void bUm()
  {
    this.otq.setVisibility(8);
    this.otr.setBackgroundResource(2131231365);
    this.otr.setVisibility(0);
    this.ots.setEnabled(true);
    this.ott.setText("");
    if (this.otv == null) {
      this.otw.setVisibility(4);
    }
    for (;;)
    {
      this.ott.setVisibility(0);
      this.ott.setText(2131758319);
      this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
      this.otu.setVisibility(8);
      return;
      this.otv.setVisibility(4);
    }
  }
  
  public final void An(int paramInt)
  {
    this.otm.setVisibility(paramInt);
  }
  
  public final void Ao(int paramInt)
  {
    this.ots.setVisibility(paramInt);
  }
  
  public final void Tm(String paramString)
  {
    this.oto.setText(paramString);
  }
  
  public final void Tn(String paramString)
  {
    if (bt.isNullOrNil(paramString))
    {
      this.otp.setVisibility(8);
      return;
    }
    this.otp.setVisibility(0);
    this.otp.setText(paramString);
  }
  
  public final void a(final j.a parama)
  {
    if (this.ots != null) {
      this.ots.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(108290);
          if (a.this.a(parama, paramAnonymousView)) {
            a.this.b(parama, paramAnonymousView);
          }
          AppMethodBeat.o(108290);
        }
      });
    }
  }
  
  protected boolean a(j.a parama, View paramView)
  {
    return true;
  }
  
  protected void b(j.a parama, View paramView)
  {
    if (parama != null) {
      parama.a(this);
    }
  }
  
  protected abstract void bTZ();
  
  protected abstract int[] bUa();
  
  protected abstract int bUb();
  
  public final void bUc()
  {
    this.kEu.setText(2131758385);
  }
  
  public final ImageView bUd()
  {
    return this.otl;
  }
  
  public final void bUe()
  {
    this.otl.setImageResource(2131232662);
  }
  
  public final ImageView bUf()
  {
    return this.otm;
  }
  
  public final void bUg()
  {
    this.otm.setImageResource(2131232094);
  }
  
  public final void bUh()
  {
    this.oto.setVisibility(8);
    this.otp.setVisibility(8);
  }
  
  public final int bUi()
  {
    if (this.otj == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.otj.mStatus)) {
      return localInteger.intValue();
    }
  }
  
  public final String bUj()
  {
    if (this.otj == null) {}
    while (this.otj.ouL == null) {
      return null;
    }
    return this.otj.ouL.PackPrice;
  }
  
  protected abstract boolean bUk();
  
  protected final void bUl()
  {
    this.otq.setVisibility(8);
    this.otr.setVisibility(8);
    this.ots.setEnabled(false);
    this.otu.setVisibility(8);
    this.otw.setVisibility(0);
    this.otw.setProgress(getProgress());
    if (this.otv == null)
    {
      this.otw.setVisibility(0);
      return;
    }
    this.otv.setVisibility(0);
  }
  
  public void bUn()
  {
    if (this.otj == null) {}
    while (!bUk()) {
      return;
    }
    this.ott.setVisibility(8);
    this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131100024));
    switch (bUi())
    {
    case 1: 
    case 2: 
    case 5: 
    case 9: 
    default: 
      ad.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[] { Integer.valueOf(bUi()) });
      return;
    case 8: 
      this.otq.setVisibility(8);
      this.otr.setBackgroundDrawable(null);
      this.otr.setVisibility(0);
      this.ots.setEnabled(false);
      this.ott.setVisibility(0);
      this.ott.setText(2131758322);
      this.otu.setVisibility(4);
      if (this.otv == null)
      {
        this.otw.setVisibility(4);
        return;
      }
      this.otv.setVisibility(4);
      return;
    case 0: 
      bUm();
      return;
    case 6: 
      bUl();
      return;
    case 7: 
      if (this.otj.ouP)
      {
        ad.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
        this.otq.setVisibility(8);
        this.otr.setBackgroundResource(2131231365);
        this.otr.setVisibility(0);
        this.otr.setTag(getProductId());
        this.ots.setEnabled(true);
        this.ott.setVisibility(0);
        this.ott.setText(2131758387);
        this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.otu.setVisibility(4);
        if (this.otv == null)
        {
          this.otw.setVisibility(4);
          return;
        }
        this.otv.setVisibility(4);
        return;
      }
      if ((this.otj.ouR) && (e.fd(this.otj.ouL.PackFlag, 64)))
      {
        this.otr.setVisibility(0);
        this.otr.setBackgroundResource(2131231370);
        this.ott.setVisibility(0);
        this.ott.setText(2131758352);
        this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131101185));
        this.otu.setVisibility(4);
        this.ots.setEnabled(true);
        if (this.otv == null)
        {
          this.otw.setVisibility(4);
          return;
        }
        this.otv.setVisibility(4);
        return;
      }
      this.otq.setVisibility(8);
      this.otr.setVisibility(0);
      this.otr.setBackgroundResource(2131231372);
      this.ott.setVisibility(0);
      this.ott.setText(2131758321);
      this.ott.setTextColor(this.mContext.getResources().getColorStateList(2131100022));
      this.otu.setVisibility(4);
      this.ots.setEnabled(false);
      if (this.otv == null)
      {
        this.otw.setVisibility(4);
        return;
      }
      this.otv.setVisibility(4);
      return;
    case 3: 
      bUm();
      return;
    case 4: 
    case 12: 
      this.otq.setVisibility(8);
      this.otr.setBackgroundResource(2131231372);
      this.otr.setVisibility(0);
      if (this.otv == null) {
        this.otw.setVisibility(4);
      }
      for (;;)
      {
        this.ots.setEnabled(true);
        this.otu.setVisibility(4);
        this.ott.setVisibility(0);
        if (this.otj.ouL == null) {
          break;
        }
        this.ott.setText(this.otj.ouL.PackPrice);
        return;
        this.otv.setVisibility(4);
      }
    case 10: 
      this.otq.setVisibility(8);
      this.otr.setBackgroundResource(2131231372);
      this.otr.setVisibility(0);
      this.ott.setVisibility(0);
      this.ott.setText(2131758343);
      this.otu.setVisibility(4);
      this.ots.setEnabled(true);
      if (this.otv == null)
      {
        this.otw.setVisibility(4);
        return;
      }
      this.otv.setVisibility(4);
      return;
    }
    this.otq.setVisibility(0);
    this.otr.setBackgroundResource(2131231372);
    this.otr.setVisibility(0);
    this.ott.setVisibility(0);
    this.ott.setText("");
    this.ots.setEnabled(false);
    this.otu.setVisibility(4);
    if (this.otv == null)
    {
      this.otw.setVisibility(4);
      return;
    }
    this.otv.setVisibility(4);
  }
  
  public final String getProductId()
  {
    if (this.otj == null) {}
    while (this.otj.ouL == null) {
      return null;
    }
    return this.otj.ouL.ProductID;
  }
  
  public final int getProgress()
  {
    if (this.otj == null) {
      return 0;
    }
    return this.otj.EI;
  }
  
  public final View getRoot()
  {
    return this.iIW;
  }
  
  public final void setTitle(String paramString)
  {
    this.kEu.setText(paramString);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(108294);
      otD = new a("LIST", 0);
      otE = new a("GRID_MAIN", 1);
      otF = new a("GRID_RECOMMEND", 2);
      otG = new a[] { otD, otE, otF };
      AppMethodBeat.o(108294);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */