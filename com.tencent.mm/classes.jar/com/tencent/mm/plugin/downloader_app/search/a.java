package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private Context mContext;
  ArrayList<b> mDataList;
  private DownloadSearchListView pps;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(8929);
    this.mDataList = new ArrayList();
    this.mContext = paramContext;
    this.pps = paramDownloadSearchListView;
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
    extends RecyclerView.w
  {
    public View contentView;
    public TextView iCU;
    public Button ppA;
    public LinearLayout ppB;
    public TextView ppC;
    public View ppt;
    public TextView ppu;
    public View ppv;
    public TextView ppw;
    public ImageView ppx;
    public View ppy;
    public ImageView ppz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(8927);
      this.contentView = paramView;
      this.ppt = this.contentView.findViewById(2131304419);
      this.ppu = ((TextView)this.contentView.findViewById(2131300748));
      this.ppu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8924);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = a.a(a.this);
          paramAnonymousView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
          if (paramAnonymousView.ppH != null) {
            paramAnonymousView.ppH.clear();
          }
          paramAnonymousView.setData(null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8924);
        }
      });
      this.ppv = this.contentView.findViewById(2131304421);
      this.ppw = ((TextView)this.contentView.findViewById(2131304429));
      this.ppx = ((ImageView)this.contentView.findViewById(2131304409));
      this.ppx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8925);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          localObject = a.a(a.this);
          String str = paramAnonymousView.ppR;
          if (!bt.isNullOrNil(str))
          {
            b.ak(((DownloadSearchListView)localObject).mContext, str);
            ((DownloadSearchListView)localObject).ppH = b.ey(((DownloadSearchListView)localObject).mContext);
            ((DownloadSearchListView)localObject).setData(((DownloadSearchListView)localObject).ppH);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8925);
        }
      });
      this.ppy = this.contentView.findViewById(2131304444);
      this.ppz = ((ImageView)this.contentView.findViewById(2131296852));
      this.ppA = ((Button)this.contentView.findViewById(2131301141));
      this.ppA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8926);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          a.a(a.this).aaF(paramAnonymousView.ppR);
          if (a.b(a.this).getResources().getString(2131760670).equals(a.a.this.ppA.getText().toString()))
          {
            com.tencent.mm.plugin.downloader.i.a.a(a.b(a.this), paramAnonymousView.appId, null);
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 22, paramAnonymousView.appId, "", "");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(8926);
            return;
            if (a.b(a.this).getResources().getString(2131760341).equals(a.a.this.ppA.getText().toString()))
            {
              localObject = d.aad(paramAnonymousView.appId);
              if (localObject == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8926);
                return;
              }
              if (i.fv(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))
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
              ((c)g.ab(c.class)).a(a.b(a.this), (Intent)localObject, null);
              com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 23, paramAnonymousView.appId, "", "");
            }
          }
        }
      });
      this.iCU = ((TextView)this.contentView.findViewById(2131296866));
      this.ppB = ((LinearLayout)this.contentView.findViewById(2131296877));
      this.ppC = ((TextView)this.contentView.findViewById(2131296873));
      AppMethodBeat.o(8927);
    }
    
    static String uo(long paramLong)
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
      if (paramInt == 2131760341)
      {
        this.ppA.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099699));
        this.ppA.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131101179));
      }
      for (;;)
      {
        this.ppA.setText(paramInt);
        AppMethodBeat.o(183809);
        return;
        this.ppA.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099655));
        this.ppA.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131099703));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */