package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private Context mContext;
  ArrayList<b> mDataList;
  private DownloadSearchListView qLp;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(8929);
    this.mDataList = new ArrayList();
    this.mContext = paramContext;
    this.qLp = paramDownloadSearchListView;
    AppMethodBeat.o(8929);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(8931);
    int i = this.mDataList.size();
    AppMethodBeat.o(8931);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(8930);
    paramInt = ((b)this.mDataList.get(paramInt)).type;
    AppMethodBeat.o(8930);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    public View contentView;
    public TextView jBQ;
    public View qLq;
    public TextView qLr;
    public View qLs;
    public TextView qLt;
    public ImageView qLu;
    public View qLv;
    public ImageView qLw;
    public Button qLx;
    public LinearLayout qLy;
    public TextView qLz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(8927);
      this.contentView = paramView;
      this.qLq = this.contentView.findViewById(2131307386);
      this.qLr = ((TextView)this.contentView.findViewById(2131302336));
      this.qLr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8924);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = a.a(a.this);
          paramAnonymousView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
          if (paramAnonymousView.qLE != null) {
            paramAnonymousView.qLE.clear();
          }
          paramAnonymousView.setData(null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8924);
        }
      });
      this.qLs = this.contentView.findViewById(2131307389);
      this.qLt = ((TextView)this.contentView.findViewById(2131307400));
      this.qLu = ((ImageView)this.contentView.findViewById(2131307375));
      this.qLu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8925);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          localObject = a.a(a.this);
          String str = paramAnonymousView.qLO;
          if (!Util.isNullOrNil(str))
          {
            b.av(((DownloadSearchListView)localObject).mContext, str);
            ((DownloadSearchListView)localObject).qLE = b.eX(((DownloadSearchListView)localObject).mContext);
            ((DownloadSearchListView)localObject).setData(((DownloadSearchListView)localObject).qLE);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8925);
        }
      });
      this.qLv = this.contentView.findViewById(2131307420);
      this.qLw = ((ImageView)this.contentView.findViewById(2131296944));
      this.qLx = ((Button)this.contentView.findViewById(2131302795));
      this.qLx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8926);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          a.a(a.this).alC(paramAnonymousView.qLO);
          if (a.b(a.this).getResources().getString(2131762201).equals(a.a.this.qLx.getText().toString()))
          {
            com.tencent.mm.plugin.downloader.i.a.as(a.b(a.this), paramAnonymousView.appId);
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 22, paramAnonymousView.appId, "", "");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(8926);
            return;
            if (a.b(a.this).getResources().getString(2131761786).equals(a.a.this.qLx.getText().toString()))
            {
              localObject = d.alb(paramAnonymousView.appId);
              if (localObject == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8926);
                return;
              }
              if (s.YS(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))
              {
                com.tencent.mm.plugin.downloader.i.a.a(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId, false, null);
                com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 44, paramAnonymousView.appId, "", "");
              }
            }
            else
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("appId", paramAnonymousView.appId);
              ((Intent)localObject).addFlags(67108864);
              ((c)g.af(c.class)).a(a.b(a.this), (Intent)localObject, null);
              com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 23, paramAnonymousView.appId, "", "");
            }
          }
        }
      });
      this.jBQ = ((TextView)this.contentView.findViewById(2131296959));
      this.qLy = ((LinearLayout)this.contentView.findViewById(2131296970));
      this.qLz = ((TextView)this.contentView.findViewById(2131296966));
      AppMethodBeat.o(8927);
    }
    
    static String CJ(long paramLong)
    {
      AppMethodBeat.i(8928);
      if (paramLong >= 1073741824L)
      {
        str = String.format("%.1fGB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
        AppMethodBeat.o(8928);
        return str;
      }
      if (paramLong >= 1048576L)
      {
        str = String.format("%.1fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
        AppMethodBeat.o(8928);
        return str;
      }
      String str = String.format("%.2fMB", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
      AppMethodBeat.o(8928);
      return str;
    }
    
    final void setButtonText(int paramInt)
    {
      AppMethodBeat.i(183809);
      if (paramInt == 2131761786)
      {
        this.qLx.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099710));
        this.qLx.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131101424));
      }
      for (;;)
      {
        this.qLx.setText(paramInt);
        AppMethodBeat.o(183809);
        return;
        this.qLx.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099655));
        this.qLx.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131099715));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */