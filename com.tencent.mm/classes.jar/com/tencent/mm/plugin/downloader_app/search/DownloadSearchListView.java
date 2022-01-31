package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class DownloadSearchListView
  extends MRecyclerView
{
  a iSN;
  List<b> iSO;
  List<b> iSP;
  private a.b iSQ = new DownloadSearchListView.1(this);
  Context mContext;
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public DownloadSearchListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  public final void Ag(String paramString)
  {
    int i = 0;
    if (bk.bl(paramString)) {
      return;
    }
    Object localObject = this.mContext;
    if (!bk.bl(paramString))
    {
      b.ad((Context)localObject, paramString);
      localObject = ((Context)localObject).getSharedPreferences("search_history_href", 0);
      String str = ((SharedPreferences)localObject).getString("search_history_list", "");
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(Base64.encodeToString(paramString.getBytes(), 0));
      localStringBuffer.append(";");
      localStringBuffer.append(str);
      paramString = localStringBuffer.toString().split(";");
      localStringBuffer.setLength(0);
      while ((i < paramString.length) && (i < 10))
      {
        localStringBuffer.append(paramString[i]);
        localStringBuffer.append(";");
        i += 1;
      }
      ((SharedPreferences)localObject).edit().putString("search_history_list", localStringBuffer.toString()).commit();
    }
    this.iSO = b.cV(this.mContext);
  }
  
  protected void onAttachedToWindow()
  {
    y.i("MicroMsg.DownloadSearchListView", "onAttachedToWindow");
    super.onAttachedToWindow();
    com.tencent.mm.plugin.downloader.b.a.a(this.iSQ);
  }
  
  protected void onDetachedFromWindow()
  {
    y.i("MicroMsg.DownloadSearchListView", "onDetachedFromWindow");
    super.onDetachedFromWindow();
    com.tencent.mm.plugin.downloader.b.a.b(this.iSQ);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    getContext();
    setLayoutManager(new LinearLayoutManager());
    this.iSN = new a(this.mContext, this);
    setAdapter(this.iSN);
    a(new c(getResources()));
    this.iSO = b.cV(this.mContext);
    this.iSP = new ArrayList();
  }
  
  void setData(List<b> paramList)
  {
    a locala = this.iSN;
    locala.hka.clear();
    if (!bk.dk(paramList)) {
      locala.hka.addAll(paramList);
    }
    locala.agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.DownloadSearchListView
 * JD-Core Version:    0.7.0.1
 */