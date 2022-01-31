package com.tencent.mm.plugin.downloader_app.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.c.a;
import java.util.Iterator;
import java.util.LinkedList;

final class TaskListView$10
  implements DialogInterface.OnClickListener
{
  TaskListView$10(TaskListView paramTaskListView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(136300);
    paramDialogInterface = this.ldh;
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramDialogInterface.lcX.lcP.iterator();
    while (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.gDG)
      {
        localLinkedList.add(locali);
        j.lI(locali.appId);
        c.b(locali);
        switch (locali.type)
        {
        case 3: 
        case 5: 
        default: 
          paramInt = 0;
        }
        for (;;)
        {
          a.a(11, paramInt, locali.position, 81, locali.appId, "", "");
          break;
          paramInt = 1101;
          continue;
          paramInt = 1102;
          continue;
          paramInt = 1103;
        }
      }
    }
    if (localLinkedList.size() != 0)
    {
      paramDialogInterface.lcX.P(localLinkedList);
      if (paramDialogInterface.lcX.bjQ()) {
        paramDialogInterface.bka();
      }
    }
    d.gw(false);
    AppMethodBeat.o(136300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskListView.10
 * JD-Core Version:    0.7.0.1
 */