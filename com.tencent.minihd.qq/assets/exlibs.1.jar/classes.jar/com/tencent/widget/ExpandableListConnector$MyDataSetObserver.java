package com.tencent.widget;

import android.database.DataSetObserver;

public class ExpandableListConnector$MyDataSetObserver
  extends DataSetObserver
{
  protected ExpandableListConnector$MyDataSetObserver(ExpandableListConnector paramExpandableListConnector) {}
  
  public void onChanged()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    ExpandableListConnector.a(this.a, true, true);
    this.a.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.ExpandableListConnector.MyDataSetObserver
 * JD-Core Version:    0.7.0.1
 */