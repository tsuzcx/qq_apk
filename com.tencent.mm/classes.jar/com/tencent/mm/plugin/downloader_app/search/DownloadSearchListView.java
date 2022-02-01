package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.b.a.b;
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
  a qLD;
  List<b> qLE;
  List<b> qLF;
  private a.b qLG;
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8935);
    this.qLG = new a.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.Cw(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
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
              locala.atj.notifyChanged();
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
    this.qLG = new a.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.Cw(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
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
              locala.atj.notifyChanged();
            }
          }
        }
        AppMethodBeat.o(8934);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(8936);
  }
  
  public final void alC(String paramString)
  {
    AppMethodBeat.i(8940);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8940);
      return;
    }
    b.au(this.mContext, paramString);
    this.qLE = b.eX(this.mContext);
    AppMethodBeat.o(8940);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8937);
    Log.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.b.a.a(this.qLG);
    AppMethodBeat.o(8937);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8938);
    Log.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.b.a.b(this.qLG);
    AppMethodBeat.o(8938);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8939);
    super.onFinishInflate();
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.qLD = new a(this.mContext, this);
    setAdapter(this.qLD);
    a(new c(getResources()));
    this.qLE = b.eX(this.mContext);
    this.qLF = new ArrayList();
    AppMethodBeat.o(8939);
  }
  
  void setData(List<b> paramList)
  {
    AppMethodBeat.i(8941);
    a locala = this.qLD;
    locala.mDataList.clear();
    if (!Util.isNullOrNil(paramList)) {
      locala.mDataList.addAll(paramList);
    }
    locala.atj.notifyChanged();
    AppMethodBeat.o(8941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView
 * JD-Core Version:    0.7.0.1
 */