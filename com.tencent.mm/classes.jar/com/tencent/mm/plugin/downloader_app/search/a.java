package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.plugin.downloader_app.e.d;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  private Context mContext;
  ArrayList<b> mDataList;
  private DownloadSearchListView xsN;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(8929);
    this.mDataList = new ArrayList();
    this.mContext = paramContext;
    this.xsN = paramDownloadSearchListView;
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
    public TextView plq;
    public View xsO;
    public TextView xsP;
    public View xsQ;
    public TextView xsR;
    public ImageView xsS;
    public View xsT;
    public ImageView xsU;
    public Button xsV;
    public LinearLayout xsW;
    public TextView xsX;
    public TextView xsY;
    public TextView xsZ;
    public TextView xta;
    public TextView xtb;
    public ImageView xtc;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(8927);
      this.contentView = paramView;
      this.xsO = this.contentView.findViewById(e.e.xqz);
      this.xsP = ((TextView)this.contentView.findViewById(e.e.xqp));
      this.xsP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8924);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = a.a(a.this);
          paramAnonymousView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
          if (paramAnonymousView.xti != null) {
            paramAnonymousView.xti.clear();
          }
          paramAnonymousView.setData(null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8924);
        }
      });
      this.xsQ = this.contentView.findViewById(e.e.xqA);
      this.xsR = ((TextView)this.contentView.findViewById(e.e.xqB));
      this.xsS = ((ImageView)this.contentView.findViewById(e.e.xqy));
      this.xsS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8925);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          localObject = a.a(a.this);
          String str = paramAnonymousView.xts;
          if (!Util.isNullOrNil(str))
          {
            b.aw(((DownloadSearchListView)localObject).mContext, str);
            ((DownloadSearchListView)localObject).xti = b.fY(((DownloadSearchListView)localObject).mContext);
            ((DownloadSearchListView)localObject).setData(((DownloadSearchListView)localObject).xti);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 81, "", "", "");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(8925);
        }
      });
      this.xsT = this.contentView.findViewById(e.e.search_result_layout);
      this.xsU = ((ImageView)this.contentView.findViewById(e.e.app_icon));
      this.xsV = ((Button)this.contentView.findViewById(e.e.xqr));
      this.xsV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8926);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = (b)paramAnonymousView.getTag();
          a.a(a.this).ank(paramAnonymousView.xts);
          if (a.b(a.this).getResources().getString(e.h.xrr).equals(a.a.this.xsV.getText().toString()))
          {
            com.tencent.mm.plugin.downloader.h.a.at(a.b(a.this), paramAnonymousView.appId);
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 22, paramAnonymousView.appId, "", "");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(8926);
            return;
            if (a.b(a.this).getResources().getString(e.h.xrp).equals(a.a.this.xsV.getText().toString()))
            {
              localObject = d.amJ(paramAnonymousView.appId);
              if (localObject == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/search/DownloadSearchAdapter$SearchViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(8926);
                return;
              }
              if (y.ZC(((com.tencent.mm.plugin.downloader.f.a)localObject).field_filePath))
              {
                com.tencent.mm.plugin.downloader.h.a.a(((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadId, false, null);
                com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 44, paramAnonymousView.appId, "", "");
              }
            }
            else
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("appId", paramAnonymousView.appId);
              ((Intent)localObject).addFlags(67108864);
              ((c)h.ax(c.class)).a(a.b(a.this), (Intent)localObject, null);
              com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 23, paramAnonymousView.appId, "", "");
            }
          }
        }
      });
      this.plq = ((TextView)this.contentView.findViewById(e.e.app_name_tv));
      this.xsW = ((LinearLayout)this.contentView.findViewById(e.e.xpV));
      this.xsX = ((TextView)this.contentView.findViewById(e.e.xpU));
      this.xsY = ((TextView)this.contentView.findViewById(e.e.xqn));
      this.xsZ = ((TextView)this.contentView.findViewById(e.e.xqo));
      this.xta = ((TextView)this.contentView.findViewById(e.e.xqv));
      this.xtb = ((TextView)this.contentView.findViewById(e.e.xqw));
      this.xtc = ((ImageView)this.contentView.findViewById(e.e.xpQ));
      if (aw.isDarkMode())
      {
        this.xtc.setImageResource(e.d.xpR);
        AppMethodBeat.o(8927);
        return;
      }
      this.xtc.setImageResource(e.d.xpQ);
      AppMethodBeat.o(8927);
    }
    
    static String ln(long paramLong)
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
      if (paramInt == e.h.xrp)
      {
        this.xsV.setBackgroundResource(e.d.btn_solid_green_small);
        this.xsV.setTextColor(androidx.core.content.a.w(a.b(a.this), e.b.white));
      }
      for (;;)
      {
        this.xsV.setText(paramInt);
        AppMethodBeat.o(183809);
        return;
        this.xsV.setBackgroundResource(e.d.btn_solid_white);
        this.xsV.setTextColor(androidx.core.content.a.w(a.b(a.this), e.b.Brand_90));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */