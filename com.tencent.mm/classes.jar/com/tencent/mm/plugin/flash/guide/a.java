package com.tencent.mm.plugin.flash.guide;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.j;

public final class a
  extends e
{
  public a(Context paramContext)
  {
    super(paramContext, a.j.CustomSheetStyle);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(264600);
    super.onCreate(paramBundle);
    setContentView(a.g.face_flash_reset_tip_dialog);
    getWindow().setLayout(-1, -2);
    getWindow().setGravity(80);
    findViewById(a.e.face_flash_reset_tip_btn).setOnClickListener(new a.1(this));
    AppMethodBeat.o(264600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.guide.a
 * JD-Core Version:    0.7.0.1
 */