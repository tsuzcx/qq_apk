package com.tencent.mm.plugin.downloader_app.search;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader_app.b.e;

public final class a$a
  extends RecyclerView.v
{
  public View contentView;
  public TextView iSA;
  public View iSB;
  public TextView iSC;
  public ImageView iSD;
  public View iSE;
  public ImageView iSF;
  public Button iSG;
  public TextView iSH;
  public LinearLayout iSI;
  public TextView iSJ;
  public View iSz;
  
  public a$a(a parama, View paramView)
  {
    super(paramView);
    this.contentView = paramView;
    this.iSz = this.contentView.findViewById(b.e.search_header_layout);
    this.iSA = ((TextView)this.contentView.findViewById(b.e.hist_clear));
    this.iSA.setOnClickListener(new a.a.1(this, parama));
    this.iSB = this.contentView.findViewById(b.e.search_history_layout);
    this.iSC = ((TextView)this.contentView.findViewById(b.e.search_item_name));
    this.iSD = ((ImageView)this.contentView.findViewById(b.e.search_del_img));
    this.iSD.setOnClickListener(new a.a.2(this, parama));
    this.iSE = this.contentView.findViewById(b.e.search_result_layout);
    this.iSF = ((ImageView)this.contentView.findViewById(b.e.app_icon));
    this.iSG = ((Button)this.contentView.findViewById(b.e.item_btn));
    this.iSG.setOnClickListener(new a.a.3(this, parama));
    this.iSH = ((TextView)this.contentView.findViewById(b.e.app_name_tv));
    this.iSI = ((LinearLayout)this.contentView.findViewById(b.e.app_tag_layout));
    this.iSJ = ((TextView)this.contentView.findViewById(b.e.app_size_tv));
  }
  
  static String ds(long paramLong)
  {
    if (paramLong >= 1073741824L) {
      return String.format("%.1fGB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
    }
    if (paramLong >= 1048576L) {
      return String.format("%.1fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
    }
    return String.format("%.2fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a
 * JD-Core Version:    0.7.0.1
 */