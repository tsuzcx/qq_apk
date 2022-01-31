package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.tencent.kinda.gen.KLoadingImage;
import com.tencent.kinda.gen.LoadingImageStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;

public class MMKLoadingImage
  extends MMKView<LinearLayout>
  implements KLoadingImage
{
  private CircleProgressDrawable circleProgressDrawable;
  private LoadingImageStyle loadingImageStype;
  private ProgressBar progressBar;
  
  public LinearLayout createView(Context paramContext)
  {
    AppMethodBeat.i(144928);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    this.progressBar = new ProgressBar(paramContext);
    this.circleProgressDrawable = new CircleProgressDrawable(paramContext);
    this.circleProgressDrawable.setStrokeColor(2131690144);
    this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
    this.progressBar.setVisibility(8);
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.addView(this.progressBar, paramContext);
    AppMethodBeat.o(144928);
    return localLinearLayout;
  }
  
  public LoadingImageStyle getStyle()
  {
    return this.loadingImageStype;
  }
  
  public void setStyle(LoadingImageStyle paramLoadingImageStyle)
  {
    AppMethodBeat.i(144931);
    this.loadingImageStype = paramLoadingImageStyle;
    if (paramLoadingImageStyle == LoadingImageStyle.WHITE) {
      this.circleProgressDrawable.setStrokeColor(2131690710);
    }
    for (;;)
    {
      this.progressBar.setIndeterminateDrawable(this.circleProgressDrawable);
      AppMethodBeat.o(144931);
      return;
      if (paramLoadingImageStyle == LoadingImageStyle.WHITELARGE) {
        this.circleProgressDrawable.setStrokeColor(2131690710);
      } else if (paramLoadingImageStyle == LoadingImageStyle.GRAY) {
        this.circleProgressDrawable.setStrokeColor(2131690144);
      }
    }
  }
  
  public void startAnimating()
  {
    AppMethodBeat.i(144929);
    this.circleProgressDrawable.aQG();
    this.circleProgressDrawable.start();
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(144929);
  }
  
  public void stopAnimating()
  {
    AppMethodBeat.i(144930);
    this.circleProgressDrawable.stop();
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(144930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKLoadingImage
 * JD-Core Version:    0.7.0.1
 */