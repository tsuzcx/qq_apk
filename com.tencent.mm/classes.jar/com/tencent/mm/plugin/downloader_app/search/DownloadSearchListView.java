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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadSearchListView
  extends MRecyclerView
{
  Context mContext;
  a oLY;
  List<b> oLZ;
  List<b> oMa;
  private a.b oMb;
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(8935);
    this.oMb = new a.b()
    {
      public final void K(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.sc(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
            if ((!bs.gY(locala.ijj)) && (!bs.isNullOrNil((String)localObject)))
            {
              Iterator localIterator = locala.ijj.iterator();
              while (localIterator.hasNext())
              {
                b localb = (b)localIterator.next();
                if ((localb.appId != null) && (localb.appId.equals(localObject))) {
                  localb.state = 2;
                }
              }
              locala.arg.notifyChanged();
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
    this.oMb = new a.b()
    {
      public final void K(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(8934);
        if (paramAnonymousInt == 9)
        {
          Object localObject = d.sc(paramAnonymousLong);
          if (localObject != null)
          {
            a locala = DownloadSearchListView.a(DownloadSearchListView.this);
            localObject = ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId;
            if ((!bs.gY(locala.ijj)) && (!bs.isNullOrNil((String)localObject)))
            {
              Iterator localIterator = locala.ijj.iterator();
              while (localIterator.hasNext())
              {
                b localb = (b)localIterator.next();
                if ((localb.appId != null) && (localb.appId.equals(localObject))) {
                  localb.state = 2;
                }
              }
              locala.arg.notifyChanged();
            }
          }
        }
        AppMethodBeat.o(8934);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(8936);
  }
  
  public final void WY(String paramString)
  {
    AppMethodBeat.i(8940);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8940);
      return;
    }
    b.ak(this.mContext, paramString);
    this.oLZ = b.ey(this.mContext);
    AppMethodBeat.o(8940);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(8937);
    ac.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.b.a.a(this.oMb);
    AppMethodBeat.o(8937);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(8938);
    ac.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.b.a.b(this.oMb);
    AppMethodBeat.o(8938);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(8939);
    super.onFinishInflate();
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.oLY = new a(this.mContext, this);
    setAdapter(this.oLY);
    a(new c(getResources()));
    this.oLZ = b.ey(this.mContext);
    this.oMa = new ArrayList();
    AppMethodBeat.o(8939);
  }
  
  void setData(List<b> paramList)
  {
    AppMethodBeat.i(8941);
    a locala = this.oLY;
    locala.ijj.clear();
    if (!bs.gY(paramList)) {
      locala.ijj.addAll(paramList);
    }
    locala.arg.notifyChanged();
    AppMethodBeat.o(8941);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView
 * JD-Core Version:    0.7.0.1
 */