package com.tencent.qav;

import android.content.Context;
import com.tencent.qav.channel.VideoChannelInterface;
import com.tencent.qav.controller.c2c.IC2COperator;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.controller.nodereport.NodeReportOperator;
import com.tencent.qav.observer.FilterableObserver;

public abstract interface IQavSDK
{
  public abstract void addObserver(FilterableObserver paramFilterableObserver);
  
  public abstract IC2COperator getC2COperator();
  
  public abstract IMultiOperator getMultiOperator();
  
  public abstract NodeReportOperator getNodeReportOperator();
  
  public abstract void initSDK(Context paramContext, long paramLong, VideoChannelInterface paramVideoChannelInterface);
  
  public abstract void removeObserver(FilterableObserver paramFilterableObserver);
  
  public abstract void unInitSDK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.IQavSDK
 * JD-Core Version:    0.7.0.1
 */