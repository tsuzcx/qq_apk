package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.sdk.platformtools.bt;

public class DownloadUpdateDescView
  extends FrameLayout
{
  private TextView kch;
  private i pqA;
  private TextView pqz;
  
  public DownloadUpdateDescView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void cdi()
  {
    AppMethodBeat.i(183819);
    this.pqz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183816);
        int i = DownloadUpdateDescView.b(DownloadUpdateDescView.this).getLineCount();
        if (i > 2)
        {
          AppMethodBeat.o(183816);
          return;
        }
        Layout localLayout = DownloadUpdateDescView.b(DownloadUpdateDescView.this).getLayout();
        TextPaint localTextPaint = DownloadUpdateDescView.b(DownloadUpdateDescView.this).getPaint();
        if ((localLayout != null) && (i > 0) && (localLayout.getEllipsisCount(i - 1) > 0))
        {
          int j = localLayout.getLineEnd(0);
          String str2 = DownloadUpdateDescView.b(DownloadUpdateDescView.this).getText().toString();
          String str1 = str2.substring(j, j * 2);
          i = (int)localTextPaint.measureText(str1);
          int k = (int)localTextPaint.measureText(".");
          int m = (int)localTextPaint.measureText(DownloadUpdateDescView.this.getResources().getString(2131758626));
          while ((i + k * 3 + m > localLayout.getEllipsizedWidth()) && (str1.length() > 0))
          {
            str1 = str1.substring(0, str1.length() - 1);
            i = (int)localTextPaint.measureText(str1);
          }
          str1 = str2.substring(0, j) + str1 + "...";
          DownloadUpdateDescView.b(DownloadUpdateDescView.this).setText(str1);
          DownloadUpdateDescView.a(DownloadUpdateDescView.this).setVisibility(0);
        }
        AppMethodBeat.o(183816);
      }
    });
    AppMethodBeat.o(183819);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(183817);
    super.onFinishInflate();
    this.pqz = ((TextView)findViewById(2131306205));
    this.kch = ((TextView)findViewById(2131306204));
    this.kch.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(183815);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/DownloadUpdateDescView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (DownloadUpdateDescView.a(DownloadUpdateDescView.this).getText().equals(DownloadUpdateDescView.this.getResources().getString(2131758626)))
        {
          DownloadUpdateDescView.b(DownloadUpdateDescView.this).setMaxLines(2147483647);
          DownloadUpdateDescView.b(DownloadUpdateDescView.this).setText(DownloadUpdateDescView.c(DownloadUpdateDescView.this).ppj);
          DownloadUpdateDescView.a(DownloadUpdateDescView.this).setText(2131761827);
        }
        for (;;)
        {
          com.tencent.mm.plugin.downloader_app.b.a.a(10, 1003, 0, 2, DownloadUpdateDescView.c(DownloadUpdateDescView.this).appId, "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/DownloadUpdateDescView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(183815);
          return;
          DownloadUpdateDescView.b(DownloadUpdateDescView.this).setMaxLines(2);
          DownloadUpdateDescView.a(DownloadUpdateDescView.this).setText(2131758626);
          DownloadUpdateDescView.d(DownloadUpdateDescView.this);
        }
      }
    });
    AppMethodBeat.o(183817);
  }
  
  public void setData(i parami)
  {
    AppMethodBeat.i(183818);
    this.pqA = parami;
    if (!bt.isNullOrNil(this.pqA.ppj))
    {
      setVisibility(0);
      this.pqz.setMaxLines(2);
      this.kch.setVisibility(8);
      this.pqz.setText(this.pqA.ppj);
      cdi();
      AppMethodBeat.o(183818);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(183818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadUpdateDescView
 * JD-Core Version:    0.7.0.1
 */