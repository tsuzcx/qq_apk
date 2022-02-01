package com.tencent.midas.comm;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.tool.APMidasCommMethod;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class APProgressDialog
  extends ProgressDialog
{
  private Context context = null;
  private String loadingTxt = "请稍候...";
  private TextView loading_txt = null;
  
  public APProgressDialog(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253546);
    super.onCreate(paramBundle);
    setContentView(APMidasCommMethod.getLayoutId(this.context, "unipay_layout_loadding"));
    paramBundle = (ProgressBar)findViewById(APMidasCommMethod.getId(this.context, "unipay_progress"));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
    localAlphaAnimation.setDuration(600L);
    localAlphaAnimation.setRepeatCount(-1);
    localAlphaAnimation.setRepeatMode(2);
    paramBundle.setAnimation(localAlphaAnimation);
    localAlphaAnimation.start();
    this.loading_txt = ((TextView)findViewById(APMidasCommMethod.getId(this.context, "unipay_id_LoadingTxt")));
    this.loading_txt.setText(this.loadingTxt);
    setCancelable(false);
    AppMethodBeat.o(253546);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253549);
    if (paramInt == 4)
    {
      cancel();
      AppMethodBeat.o(253549);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(253549);
    return bool;
  }
  
  public void setMessage(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(253548);
    super.setMessage(paramCharSequence);
    this.loadingTxt = String.valueOf(paramCharSequence);
    AppMethodBeat.o(253548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.APProgressDialog
 * JD-Core Version:    0.7.0.1
 */