package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoggingBehavior
{
  static
  {
    AppMethodBeat.i(17239);
    REQUESTS = new LoggingBehavior("REQUESTS", 0);
    INCLUDE_ACCESS_TOKENS = new LoggingBehavior("INCLUDE_ACCESS_TOKENS", 1);
    INCLUDE_RAW_RESPONSES = new LoggingBehavior("INCLUDE_RAW_RESPONSES", 2);
    CACHE = new LoggingBehavior("CACHE", 3);
    APP_EVENTS = new LoggingBehavior("APP_EVENTS", 4);
    DEVELOPER_ERRORS = new LoggingBehavior("DEVELOPER_ERRORS", 5);
    GRAPH_API_DEBUG_WARNING = new LoggingBehavior("GRAPH_API_DEBUG_WARNING", 6);
    GRAPH_API_DEBUG_INFO = new LoggingBehavior("GRAPH_API_DEBUG_INFO", 7);
    $VALUES = new LoggingBehavior[] { REQUESTS, INCLUDE_ACCESS_TOKENS, INCLUDE_RAW_RESPONSES, CACHE, APP_EVENTS, DEVELOPER_ERRORS, GRAPH_API_DEBUG_WARNING, GRAPH_API_DEBUG_INFO };
    AppMethodBeat.o(17239);
  }
  
  private LoggingBehavior() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.LoggingBehavior
 * JD-Core Version:    0.7.0.1
 */