package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
  extends RecyclerView.a<a>
{
  ArrayList<b> iVH;
  DownloadSearchListView lbi;
  Context mContext;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(136168);
    this.iVH = new ArrayList();
    this.mContext = paramContext;
    this.lbi = paramDownloadSearchListView;
    AppMethodBeat.o(136168);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(136170);
    int i = this.iVH.size();
    AppMethodBeat.o(136170);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(136169);
    paramInt = ((b)this.iVH.get(paramInt)).type;
    AppMethodBeat.o(136169);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    public View contentView;
    public View lbj;
    public TextView lbk;
    public View lbl;
    public TextView lbm;
    public ImageView lbn;
    public View lbo;
    public ImageView lbp;
    public Button lbq;
    public TextView lbr;
    public LinearLayout lbs;
    public TextView lbt;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(136166);
      this.contentView = paramView;
      this.lbj = this.contentView.findViewById(2131827493);
      this.lbk = ((TextView)this.contentView.findViewById(2131827495));
      this.lbk.setOnClickListener(new a.a.1(this, a.this));
      this.lbl = this.contentView.findViewById(2131827496);
      this.lbm = ((TextView)this.contentView.findViewById(2131827499));
      this.lbn = ((ImageView)this.contentView.findViewById(2131827498));
      this.lbn.setOnClickListener(new a.a.2(this, a.this));
      this.lbo = this.contentView.findViewById(2131827500);
      this.lbp = ((ImageView)this.contentView.findViewById(2131821471));
      this.lbq = ((Button)this.contentView.findViewById(2131827501));
      this.lbq.setOnClickListener(new a.a.3(this, a.this));
      this.lbr = ((TextView)this.contentView.findViewById(2131821156));
      this.lbs = ((LinearLayout)this.contentView.findViewById(2131827503));
      this.lbt = ((TextView)this.contentView.findViewById(2131827504));
      AppMethodBeat.o(136166);
    }
    
    static String iW(long paramLong)
    {
      AppMethodBeat.i(136167);
      if (paramLong >= 1073741824L)
      {
        str = String.format("%.1fGB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
        AppMethodBeat.o(136167);
        return str;
      }
      if (paramLong >= 1048576L)
      {
        str = String.format("%.1fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
        AppMethodBeat.o(136167);
        return str;
      }
      String str = String.format("%.2fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
      AppMethodBeat.o(136167);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */