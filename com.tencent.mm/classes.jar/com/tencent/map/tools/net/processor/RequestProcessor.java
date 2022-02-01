package com.tencent.map.tools.net.processor;

import com.tencent.map.tools.net.NetRequest;

public abstract interface RequestProcessor
  extends Processor
{
  public abstract void onRequest(NetRequest paramNetRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.map.tools.net.processor.RequestProcessor
 * JD-Core Version:    0.7.0.1
 */