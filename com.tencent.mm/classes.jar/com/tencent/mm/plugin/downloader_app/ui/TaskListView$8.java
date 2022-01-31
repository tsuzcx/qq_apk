package com.tencent.mm.plugin.downloader_app.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.b.k;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;

final class TaskListView$8
  implements DialogInterface.OnClickListener
{
  TaskListView$8(TaskListView paramTaskListView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = this.iUe;
    paramDialogInterface = new LinkedList();
    Iterator localIterator = ((TaskListView)localObject1).iTW.iTQ.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (j)localIterator.next();
      if (((j)localObject2).fmm)
      {
        paramDialogInterface.add(localObject2);
        k.vo(((j)localObject2).appId);
        localObject2 = c.zH(((j)localObject2).appId);
        if (localObject2 != null) {
          com.tencent.mm.plugin.downloader.model.d.aFP().dc(((a)localObject2).field_downloadId);
        }
      }
    }
    if (paramDialogInterface.size() != 0)
    {
      localObject1 = ((TaskListView)localObject1).iTW;
      if (!bk.dk(paramDialogInterface))
      {
        if (paramDialogInterface.size() != 1) {
          break label167;
        }
        paramInt = ((b)localObject1).iTQ.indexOf(paramDialogInterface.get(0));
        ((b)localObject1).iTQ.remove(paramInt);
        l.m(new b.2((b)localObject1, paramInt));
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.downloader_app.b.d.eT(false);
      return;
      label167:
      ((b)localObject1).iTQ.removeAll(paramDialogInterface);
      l.m(new b.3((b)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.8
 * JD-Core Version:    0.7.0.1
 */