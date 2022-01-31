package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;

final class IPCallTalkUI$1
  implements Runnable
{
  IPCallTalkUI$1(IPCallTalkUI paramIPCallTalkUI) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    this.lzn.setResult(-1, localIntent);
    this.lzn.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI.1
 * JD-Core Version:    0.7.0.1
 */