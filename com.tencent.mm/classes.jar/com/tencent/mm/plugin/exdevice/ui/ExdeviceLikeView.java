package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.sdk.platformtools.y;

public class ExdeviceLikeView
  extends RelativeLayout
{
  private int jDt;
  private ExdeviceLikeView.a jDu;
  private int jDv = 2;
  private TextView jDw;
  private ImageView jDx;
  private ProgressBar jDy;
  private Context mContext;
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public ExdeviceLikeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    paramContext = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_like_view, this, true);
    this.jDw = ((TextView)paramContext.findViewById(R.h.exdevice_like_num));
    this.jDx = ((ImageView)paramContext.findViewById(R.h.exdevice_like_icon));
    this.jDy = ((ProgressBar)paramContext.findViewById(R.h.exdevice_loading));
    setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((ExdeviceLikeView.a(ExdeviceLikeView.this) != null) && (!ExdeviceLikeView.a(ExdeviceLikeView.this).aMA()) && (ExdeviceLikeView.b(ExdeviceLikeView.this) == 0))
        {
          y.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
          ExdeviceLikeView.this.setSelfLikeState(ExdeviceLikeView.qx(ExdeviceLikeView.b(ExdeviceLikeView.this)));
          if (ExdeviceLikeView.b(ExdeviceLikeView.this) == 1) {
            ExdeviceLikeView.c(ExdeviceLikeView.this);
          }
          if (ExdeviceLikeView.a(ExdeviceLikeView.this) != null) {
            ExdeviceLikeView.a(ExdeviceLikeView.this).gl(ExdeviceLikeView.b(ExdeviceLikeView.this));
          }
          return;
        }
        y.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
      }
    });
  }
  
  public void setLikeNum(int paramInt)
  {
    this.jDt = paramInt;
    String str = this.jDt;
    if (this.jDt < 0)
    {
      y.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
      str = "0";
      if (this.jDt > 0) {
        break label85;
      }
      this.jDw.setVisibility(8);
    }
    for (;;)
    {
      this.jDw.setText(str);
      return;
      if (paramInt <= 999) {
        break;
      }
      y.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
      str = "999+";
      break;
      label85:
      this.jDw.setVisibility(0);
    }
  }
  
  public void setOnLikeViewClickListener(ExdeviceLikeView.a parama)
  {
    this.jDu = parama;
  }
  
  public void setSelfLikeState(int paramInt)
  {
    this.jDv = paramInt;
    if (this.jDv == 1)
    {
      this.jDy.setVisibility(8);
      this.jDw.setVisibility(0);
      this.jDx.setVisibility(0);
      this.jDx.setImageResource(R.k.device_rank_item_liked);
      return;
    }
    if (this.jDv == 0)
    {
      this.jDy.setVisibility(8);
      this.jDw.setVisibility(0);
      this.jDx.setVisibility(0);
      this.jDx.setImageResource(R.k.device_rank_item_unliked);
      return;
    }
    if (this.jDv == 2)
    {
      this.jDw.setVisibility(8);
      this.jDy.setVisibility(0);
      this.jDx.setVisibility(8);
      return;
    }
    y.w("MicroMsg.ExdeviceLikeView", "hy: error state");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView
 * JD-Core Version:    0.7.0.1
 */