package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetResponse;

public abstract interface ResponseProcessor
  extends Processor
{
  public abstract void onResponse(NetResponse paramNetResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.processor.ResponseProcessor
 * JD-Core Version:    0.7.0.1
 */