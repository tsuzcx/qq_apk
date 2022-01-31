package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl
  extends VoiceInputLayout
{
  private View.OnLongClickListener asI;
  private View nbZ;
  private TextView nca;
  private b ncb;
  private boolean ncc;
  private boolean ncd;
  private long nce;
  private View.OnTouchListener ncf;
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(62190);
    this.ncc = false;
    this.ncd = false;
    this.asI = new FTSVoiceInputLayoutImpl.2(this);
    this.ncf = new FTSVoiceInputLayoutImpl.3(this);
    init(paramContext);
    AppMethodBeat.o(62190);
  }
  
  public FTSVoiceInputLayoutImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(62189);
    this.ncc = false;
    this.ncd = false;
    this.asI = new FTSVoiceInputLayoutImpl.2(this);
    this.ncf = new FTSVoiceInputLayoutImpl.3(this);
    init(paramContext);
    AppMethodBeat.o(62189);
  }
  
  private void bDA()
  {
    AppMethodBeat.i(62194);
    runOnUiThread(new FTSVoiceInputLayoutImpl.4(this));
    bDI();
    AppMethodBeat.o(62194);
  }
  
  private static boolean bDB()
  {
    AppMethodBeat.i(62195);
    int i = g.Rc().adt();
    if ((i == 4) || (i == 6))
    {
      AppMethodBeat.o(62195);
      return true;
    }
    AppMethodBeat.o(62195);
    return false;
  }
  
  private static boolean bDC()
  {
    AppMethodBeat.i(62196);
    if (((h)g.RI().Rj()).SD())
    {
      boolean bool = bDB();
      AppMethodBeat.o(62196);
      return bool;
    }
    if (at.isConnected(ah.getContext())) {}
    for (int i = 6; i == 6; i = 0)
    {
      AppMethodBeat.o(62196);
      return true;
    }
    AppMethodBeat.o(62196);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(62191);
    View localView = inflate(paramContext, 2130969677, this);
    this.nbZ = localView.findViewById(2131824403);
    this.nbZ.setLayerType(1, null);
    this.ncb = new b(paramContext);
    this.nbZ.setBackground(this.ncb);
    this.nbZ.setEnabled(true);
    this.nbZ.setOnTouchListener(this.ncf);
    this.nbZ.setOnLongClickListener(this.asI);
    this.nca = ((TextView)localView.findViewById(2131824404));
    reset(true);
    if (isInEditMode())
    {
      AppMethodBeat.o(62191);
      return;
    }
    if (!bDC()) {
      bDA();
    }
    AppMethodBeat.o(62191);
  }
  
  private static void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(62201);
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      al.d(paramRunnable);
      AppMethodBeat.o(62201);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(62201);
  }
  
  public final void B(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(62193);
    ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[] { Integer.valueOf(this.currentState), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (this.currentState == 1)
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        bDF();
        AppMethodBeat.o(62193);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        this.ncb.bDo();
        AppMethodBeat.o(62193);
      }
    }
    else if (this.currentState == 2)
    {
      if (!paramBoolean2)
      {
        bDG();
        AppMethodBeat.o(62193);
        return;
      }
      this.ncb.bDo();
      amT();
      if (this.nbV != null)
      {
        this.nbV.bDz();
        AppMethodBeat.o(62193);
      }
    }
    else
    {
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        amT();
        AppMethodBeat.o(62193);
        return;
      }
      if ((paramBoolean1) && (!paramBoolean2)) {
        this.ncb.bDo();
      }
    }
    AppMethodBeat.o(62193);
  }
  
  protected final void bDD()
  {
    AppMethodBeat.i(62197);
    runOnUiThread(new FTSVoiceInputLayoutImpl.5(this));
    AppMethodBeat.o(62197);
  }
  
  protected final void bDE()
  {
    AppMethodBeat.i(62198);
    runOnUiThread(new FTSVoiceInputLayoutImpl.6(this));
    AppMethodBeat.o(62198);
  }
  
  protected final void onReset()
  {
    AppMethodBeat.i(62199);
    runOnUiThread(new FTSVoiceInputLayoutImpl.7(this));
    AppMethodBeat.o(62199);
  }
  
  public void setFTSVoiceDetectListener(FTSVoiceInputLayoutImpl.a parama)
  {
    AppMethodBeat.i(62192);
    super.setVoiceDetectListener(parama);
    AppMethodBeat.o(62192);
  }
  
  protected final void wF(int paramInt)
  {
    AppMethodBeat.i(62200);
    runOnUiThread(new FTSVoiceInputLayoutImpl.8(this, paramInt));
    AppMethodBeat.o(62200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl
 * JD-Core Version:    0.7.0.1
 */