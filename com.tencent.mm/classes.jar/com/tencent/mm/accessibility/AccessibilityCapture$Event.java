package com.tencent.mm.accessibility;

import android.app.Activity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityCapture$Event
{
  public final Activity activity;
  public final long elapsedTime;
  public final AccessibilityEvent event;
  public final View view;
  
  public AccessibilityCapture$Event(AccessibilityEvent paramAccessibilityEvent, View paramView, Activity paramActivity, long paramLong)
  {
    this.event = paramAccessibilityEvent;
    this.view = paramView;
    this.activity = paramActivity;
    this.elapsedTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.Event
 * JD-Core Version:    0.7.0.1
 */