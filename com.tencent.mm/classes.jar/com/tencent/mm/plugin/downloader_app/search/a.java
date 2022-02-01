package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private Context mContext;
  ArrayList<b> mDataList;
  private DownloadSearchListView umB;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(8929);
    this.mDataList = new ArrayList();
    this.mContext = paramContext;
    this.umB = paramDownloadSearchListView;
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
    public TextView mrL;
    public View umC;
    public TextView umD;
    public View umE;
    public TextView umF;
    public ImageView umG;
    public View umH;
    public ImageView umI;
    public Button umJ;
    public LinearLayout umK;
    public TextView umL;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(8927);
      this.contentView = paramView;
      this.umC = this.contentView.findViewById(e.e.ukn);
      this.umD = ((TextView)this.contentView.findViewById(e.e.ukf));
      this.umD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8924);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = a.a(a.this);
          paramAnonymousView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
          if (paramAnonymousView.umQ != null) {
            paramAnonymousView.umQ.clear();
          }
          paramAnonymousView.setData(null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8924);
        }
      });
      this.umE = this.contentView.findViewById(e.e.uko);
      this.umF = ((TextView)this.contentView.findViewById(e.e.ukp));
      this.umG = ((ImageView)this.contentView.findViewById(e.e.ukm));
      this.umG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8925);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          localObject = a.a(a.this);
          String str = paramAnonymousView.una;
          if (!Util.isNullOrNil(str))
          {
            b.av(((DownloadSearchListView)localObject).mContext, str);
            ((DownloadSearchListView)localObject).umQ = b.fb(((DownloadSearchListView)localObject).mContext);
            ((DownloadSearchListView)localObject).setData(((DownloadSearchListView)localObject).umQ);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8925);
        }
      });
      this.umH = this.contentView.findViewById(e.e.search_result_layout);
      this.umI = ((ImageView)this.contentView.findViewById(e.e.app_icon));
      this.umJ = ((Button)this.contentView.findViewById(e.e.ukh));
      this.umJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8926);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          a.a(a.this).atv(paramAnonymousView.una);
          if (a.b(a.this).getResources().getString(e.h.ulf).equals(a.a.this.umJ.getText().toString()))
          {
            com.tencent.mm.plugin.downloader.i.a.as(a.b(a.this), paramAnonymousView.appId);
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 22, paramAnonymousView.appId, "", "");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(8926);
            return;
            if (a.b(a.this).getResources().getString(e.h.uld).equals(a.a.this.umJ.getText().toString()))
            {
              localObject = d.asU(paramAnonymousView.appId);
              if (localObject == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8926);
                return;
              }
              if (u.agG(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))
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
              ((c)h.ae(c.class)).a(a.b(a.this), (Intent)localObject, null);
              com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 23, paramAnonymousView.appId, "", "");
            }
          }
        }
      });
      this.mrL = ((TextView)this.contentView.findViewById(e.e.app_name_tv));
      this.umK = ((LinearLayout)this.contentView.findViewById(e.e.ujP));
      this.umL = ((TextView)this.contentView.findViewById(e.e.ujO));
      AppMethodBeat.o(8927);
    }
    
    static String IS(long paramLong)
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
      if (paramInt == e.h.uld)
      {
        this.umJ.setBackgroundColor(androidx.core.content.a.w(a.b(a.this), e.b.Brand));
        this.umJ.setTextColor(androidx.core.content.a.w(a.b(a.this), e.b.white));
      }
      for (;;)
      {
        this.umJ.setText(paramInt);
        AppMethodBeat.o(183809);
        return;
        this.umJ.setBackgroundColor(androidx.core.content.a.w(a.b(a.this), e.b.BW_0_Alpha_0_0_5));
        this.umJ.setTextColor(androidx.core.content.a.w(a.b(a.this), e.b.Brand_90));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */