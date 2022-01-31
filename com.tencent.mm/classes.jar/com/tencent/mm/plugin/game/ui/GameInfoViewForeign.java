package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.ab;

public class GameInfoViewForeign
  extends RelativeLayout
{
  private int eaG;
  private Context mContext;
  private int nok;
  private TextView nzV;
  private int nzW;
  private View.OnClickListener nzX;
  
  public GameInfoViewForeign(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111993);
    this.nok = 0;
    this.eaG = 0;
    this.nzW = 2;
    this.nzX = new GameInfoViewForeign.1(this);
    this.mContext = paramContext;
    AppMethodBeat.o(111993);
  }
  
  public final void bHo()
  {
    AppMethodBeat.i(111995);
    this.eaG = ((e)g.E(e.class)).bES().bGx();
    if ((this.eaG > 0) && (this.eaG <= 99))
    {
      this.nzV.setVisibility(0);
      this.nzV.setText(this.eaG);
      AppMethodBeat.o(111995);
      return;
    }
    if (this.eaG > 99)
    {
      this.nzV.setVisibility(0);
      this.nzV.setText("99+");
      this.nzV.setTextSize(1, 9.0F);
      AppMethodBeat.o(111995);
      return;
    }
    this.nzV.setVisibility(4);
    AppMethodBeat.o(111995);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111994);
    super.onFinishInflate();
    setOnClickListener(this.nzX);
    this.nzV = ((TextView)findViewById(2131824514));
    bHo();
    ab.i("MicroMsg.GameInfoViewForeign", "initView finished");
    AppMethodBeat.o(111994);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameInfoViewForeign
 * JD-Core Version:    0.7.0.1
 */