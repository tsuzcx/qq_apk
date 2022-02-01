package com.tencent.flutter_app;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.app.FlutterActivity;

public class MainActivity
  extends FlutterActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(159055);
    super.onCreate(paramBundle);
    io.flutter.a.fME();
    io.flutter.a.a.registerWith(this);
    AppMethodBeat.o(159055);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.flutter_app.MainActivity
 * JD-Core Version:    0.7.0.1
 */