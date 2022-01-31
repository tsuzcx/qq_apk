package com.tencent.mm.plugin.downloader_app.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bk;

final class a$a$2
  implements View.OnClickListener
{
  a$a$2(a.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = (b)paramView.getTag();
    paramView = this.iSM.iSK.iSy;
    localObject = ((b)localObject).iSX;
    if (!bk.bl((String)localObject))
    {
      b.ad(paramView.mContext, (String)localObject);
      paramView.iSO = b.cV(paramView.mContext);
      paramView.setData(paramView.iSO);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a.2
 * JD-Core Version:    0.7.0.1
 */