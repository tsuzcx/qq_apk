package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.f;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.c;

public class DeleteTaskFooterView
  extends LinearLayout
{
  private boolean Mt = true;
  private LinearLayout iTd;
  ImageView iTe;
  LinearLayout iTf;
  TextView iTg;
  ImageView iTh;
  boolean iTi = false;
  private d.c iTj = new DeleteTaskFooterView.1(this);
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    d.a(this.iTj);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d.b(this.iTj);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(b.f.delete_task_view, this, true);
    this.iTd = ((LinearLayout)localView.findViewById(b.e.check_box_container));
    this.iTe = ((ImageView)localView.findViewById(b.e.check_box));
    this.iTd.setOnClickListener(new DeleteTaskFooterView.2(this));
    this.iTf = ((LinearLayout)localView.findViewById(b.e.delete_container));
    this.iTf.setOnClickListener(new DeleteTaskFooterView.3(this));
    this.iTf.setClickable(false);
    this.iTg = ((TextView)localView.findViewById(b.e.delete));
    this.iTh = ((ImageView)localView.findViewById(b.e.delete_icon));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */