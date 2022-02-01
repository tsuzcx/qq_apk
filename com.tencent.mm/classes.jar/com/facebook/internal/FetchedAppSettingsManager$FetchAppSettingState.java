package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum FetchedAppSettingsManager$FetchAppSettingState
{
  static
  {
    AppMethodBeat.i(17745);
    NOT_LOADED = new FetchAppSettingState("NOT_LOADED", 0);
    LOADING = new FetchAppSettingState("LOADING", 1);
    SUCCESS = new FetchAppSettingState("SUCCESS", 2);
    ERROR = new FetchAppSettingState("ERROR", 3);
    $VALUES = new FetchAppSettingState[] { NOT_LOADED, LOADING, SUCCESS, ERROR };
    AppMethodBeat.o(17745);
  }
  
  private FetchedAppSettingsManager$FetchAppSettingState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.FetchedAppSettingsManager.FetchAppSettingState
 * JD-Core Version:    0.7.0.1
 */