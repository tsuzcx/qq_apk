package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class b$b
{
  public static void a(ListView paramListView)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      new ac();
      if (paramListView.getFirstVisiblePosition() > 10) {
        paramListView.setSelection(10);
      }
      if (Build.VERSION.SDK_INT >= 8) {
        paramListView.smoothScrollToPosition(0);
      }
      return;
    }
    new ab();
    paramListView.setSelection(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.b.b
 * JD-Core Version:    0.7.0.1
 */