package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bd;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public class LuckyMoneyC2CNYPredownloadImgListener
  extends IListener<bd>
{
  private ArrayList<String> Krz;
  
  public LuckyMoneyC2CNYPredownloadImgListener()
  {
    super(f.hfK);
    AppMethodBeat.i(65177);
    this.Krz = new ArrayList();
    this.__eventId = bd.class.getName().hashCode();
    AppMethodBeat.o(65177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyC2CNYPredownloadImgListener
 * JD-Core Version:    0.7.0.1
 */