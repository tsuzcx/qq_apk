package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.event.a.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadSearchListView
  extends MRecyclerView
{
  Context mContext;
  a xth;
  List<b> xti;
  List<b> xtj;
  private a.b xtk;
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8935);
    this.xtk = new a.b()
    {
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.la(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;
            if ((!Util.isNullOrNil(locala.mDataList)) && (!Util.isNullOrNil((String)localObject)))
            {
              Iterator localIterator = locala.mDataList.iterator();
              while (localIterator.hasNext())
              {
                b localb = (b)localIterator.next();
                if ((localb.appId != null) && (localb.appId.equals(localObject))) {
                  localb.state = 2;
                }
              }
              locala.bZE.notifyChanged();
            }
          }
        }
        AppMethodBeat.o(8934);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(8935);
  }
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(8936);
    this.xtk = new a.b()
    {
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.la(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;
            if ((!Util.isNullOrNil(locala.mDataList)) && (!Util.isNullOrNil((String)localObject)))
            {
              Iterator localIterator = locala.mDataList.iterator();
              while (localIterator.hasNext())
              {
                b localb = (b)localIterator.next();
                if ((localb.appId != null) && (localb.appId.equals(localObject))) {
                  localb.state = 2;
                }
              }
              locala.bZE.notifyChanged();
            }
          }
        }
        AppMethodBeat.o(8934);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(8936);
  }
  
  public final void ank(String paramString)
  {
    AppMethodBeat.i(8940);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8940);
      return;
    }
    b.av(this.mContext, paramString);
    this.xti = b.fY(this.mContext);
    AppMethodBeat.o(8940);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8937);
    Log.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.event.a.a(this.xtk);
    AppMethodBeat.o(8937);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8938);
    Log.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.event.a.b(this.xtk);
    AppMethodBeat.o(8938);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8939);
    super.onFinishInflate();
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.xth = new a(this.mContext, this);
    setAdapter(this.xth);
    a(new c(getResources()));
    this.xti = b.fY(this.mContext);
    this.xtj = new ArrayList();
    AppMethodBeat.o(8939);
  }
  
  void setData(List<b> paramList)
  {
    AppMethodBeat.i(8941);
    a locala = this.xth;
    locala.mDataList.clear();
    if (!Util.isNullOrNil(paramList)) {
      locala.mDataList.addAll(paramList);
    }
    locala.bZE.notifyChanged();
    AppMethodBeat.o(8941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView
 * JD-Core Version:    0.7.0.1
 */