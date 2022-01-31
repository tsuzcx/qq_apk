package com.tencent.mm.plugin.choosemsgfile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.d.a;

@com.tencent.mm.ui.base.a(3)
public class ChooseMsgFileShowUI
  extends MMActivity
{
  private String elt;
  private String fileName;
  private String filePath;
  private String token;
  
  public ChooseMsgFileShowUI()
  {
    AppMethodBeat.i(145997);
    this.filePath = "";
    this.elt = "";
    this.fileName = "";
    this.token = Integer.toString(hashCode());
    AppMethodBeat.o(145997);
  }
  
  public static void q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(54437);
    Intent localIntent = new Intent(paramContext, ChooseMsgFileShowUI.class);
    localIntent.putExtra("key_filepath", paramString1);
    localIntent.putExtra("key_fileext", paramString2);
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(54437);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(54434);
    super.onCreate(paramBundle);
    this.filePath = getIntent().getStringExtra("key_filepath");
    this.elt = getIntent().getStringExtra("key_fileext");
    try
    {
      int j = this.filePath.lastIndexOf('/') + 1;
      if (j < 0) {
        break label166;
      }
      i = j;
      if (j != this.filePath.length()) {}
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.ChooseMsgFileShowUI", "get file name error " + paramBundle.getMessage());
        this.fileName = "";
        continue;
        int i = 0;
      }
    }
    this.fileName = this.filePath.substring(i, this.filePath.length());
    com.tencent.mm.cn.a.a(this, this.filePath, this.fileName, this.elt, this.token, d.a.BDa, new ChooseMsgFileShowUI.1(this), new ChooseMsgFileShowUI.2(this));
    AppMethodBeat.o(54434);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(54436);
    com.tencent.mm.cn.a.M(this, this.token, this.filePath);
    super.onDestroy();
    AppMethodBeat.o(54436);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileShowUI
 * JD-Core Version:    0.7.0.1
 */