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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends RecyclerView.a<a>
{
  ArrayList<b> hIH;
  private Context mContext;
  private DownloadSearchListView oik;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    AppMethodBeat.i(8929);
    this.hIH = new ArrayList();
    this.mContext = paramContext;
    this.oik = paramDownloadSearchListView;
    AppMethodBeat.o(8929);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(8931);
    int i = this.hIH.size();
    AppMethodBeat.o(8931);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(8930);
    paramInt = ((b)this.hIH.get(paramInt)).type;
    AppMethodBeat.o(8930);
    return paramInt;
  }
  
  public final class a
    extends RecyclerView.v
  {
    public View contentView;
    public TextView hJd;
    public View oil;
    public TextView oim;
    public View oin;
    public TextView oio;
    public ImageView oip;
    public View oiq;
    public ImageView oir;
    public Button ois;
    public LinearLayout oit;
    public TextView oiu;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(8927);
      this.contentView = paramView;
      this.oil = this.contentView.findViewById(2131304419);
      this.oim = ((TextView)this.contentView.findViewById(2131300748));
      this.oim.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8924);
          paramAnonymousView = a.a(a.this);
          paramAnonymousView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
          if (paramAnonymousView.oiz != null) {
            paramAnonymousView.oiz.clear();
          }
          paramAnonymousView.setData(null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, 21, 81, "", "", "");
          AppMethodBeat.o(8924);
        }
      });
      this.oin = this.contentView.findViewById(2131304421);
      this.oio = ((TextView)this.contentView.findViewById(2131304429));
      this.oip = ((ImageView)this.contentView.findViewById(2131304409));
      this.oip.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8925);
          paramAnonymousView = (b)paramAnonymousView.getTag();
          DownloadSearchListView localDownloadSearchListView = a.a(a.this);
          String str = paramAnonymousView.oiJ;
          if (!bt.isNullOrNil(str))
          {
            b.ak(localDownloadSearchListView.mContext, str);
            localDownloadSearchListView.oiz = b.eq(localDownloadSearchListView.mContext);
            localDownloadSearchListView.setData(localDownloadSearchListView.oiz);
          }
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1302, paramAnonymousView.position, 81, "", "", "");
          AppMethodBeat.o(8925);
        }
      });
      this.oiq = this.contentView.findViewById(2131304444);
      this.oir = ((ImageView)this.contentView.findViewById(2131296852));
      this.ois = ((Button)this.contentView.findViewById(2131301141));
      this.ois.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(8926);
          paramAnonymousView = (b)paramAnonymousView.getTag();
          a.a(a.this).SM(paramAnonymousView.oiJ);
          if (a.b(a.this).getResources().getString(2131760670).equals(a.a.this.ois.getText().toString()))
          {
            com.tencent.mm.plugin.downloader.i.a.a(a.b(a.this), paramAnonymousView.appId, null);
            com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 22, paramAnonymousView.appId, "", "");
            AppMethodBeat.o(8926);
            return;
          }
          if (a.b(a.this).getResources().getString(2131760341).equals(a.a.this.ois.getText().toString()))
          {
            localObject = d.Sk(paramAnonymousView.appId);
            if (localObject == null)
            {
              AppMethodBeat.o(8926);
              return;
            }
            if (i.eK(((com.tencent.mm.plugin.downloader.g.a)localObject).field_filePath))
            {
              com.tencent.mm.plugin.downloader.i.a.a(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId, false, null);
              com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 44, paramAnonymousView.appId, "", "");
            }
            AppMethodBeat.o(8926);
            return;
          }
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("appId", paramAnonymousView.appId);
          ((Intent)localObject).addFlags(67108864);
          ((c)g.ab(c.class)).a(a.b(a.this), (Intent)localObject, null);
          com.tencent.mm.plugin.downloader_app.b.a.a(13, 1303, paramAnonymousView.position, 23, paramAnonymousView.appId, "", "");
          AppMethodBeat.o(8926);
        }
      });
      this.hJd = ((TextView)this.contentView.findViewById(2131296866));
      this.oit = ((LinearLayout)this.contentView.findViewById(2131296877));
      this.oiu = ((TextView)this.contentView.findViewById(2131296873));
      AppMethodBeat.o(8927);
    }
    
    static String oE(long paramLong)
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
        this.ois.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099699));
        this.ois.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131101179));
      }
      for (;;)
      {
        this.ois.setText(paramInt);
        AppMethodBeat.o(183809);
        return;
        this.ois.setBackgroundColor(android.support.v4.content.b.n(a.b(a.this), 2131099655));
        this.ois.setTextColor(android.support.v4.content.b.n(a.b(a.this), 2131099703));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */